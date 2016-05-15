FROM ubuntu:15.04

RUN \
    echo "===> add webupd8 repository..."  && \
    echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | tee /etc/apt/sources.list.d/webupd8team-java.list  && \
    echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | tee -a /etc/apt/sources.list.d/webupd8team-java.list  && \
    apt-key adv --keyserver keyserver.ubuntu.com --recv-keys EEA14886  && \
    apt-get update  && \
    \
    \
    echo "===> install Java"  && \
    echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections  && \
    echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections  && \
    DEBIAN_FRONTEND=noninteractive  apt-get install -y --force-yes oracle-java8-installer oracle-java8-set-default  && \
    \
    \
    echo "===> clean up..."  && \
    rm -rf /var/cache/oracle-jdk8-installer  && \
    apt-get clean  && \
    rm -rf /var/lib/apt/lists/*  && \
    apt-key adv --keyserver pool.sks-keyservers.net --recv-keys 46095ACC8548582C1A2699A9D27D666CD88E42B4 \
    && echo 'deb http://packages.elasticsearch.org/logstashforwarder/debian stable main' | tee /etc/apt/sources.list.d/logstashforwarder.list \
    && apt-get update; apt-get install -y logstash-forwarder
    


# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
ENV PATH /opt/logstash-forwarder/bin:$PATH

RUN mkdir /opt/dropwizard
RUN mkdir -p /etc/pki/tls/certs
RUN mkdir -p /etc/pki/tls/private

ADD config_aws.yml /opt/dropwizard/config_aws.yml
COPY target/LetsGetDigital-0.0.1-SNAPSHOT.jar /opt/dropwizard/
WORKDIR /opt/dropwizard
RUN java -jar LetsGetDigital-0.0.1-SNAPSHOT.jar db migrate config_aws.yml


ADD /tls/certs/logstash-forwarder.crt /etc/pki/tls/certs/logstash-forwarder.crt 
ADD /tls/private/logstash-forwarder.key /etc/pki/tls/private/logstash-forwarder.key
ADD /docker-logstash-forwarder/logstash-forwarder.conf /etc/logstash-forwarder.conf
ADD start.sh  /start.sh



RUN chmod 755 /start.sh

VOLUME ["/logstash-forwarder-conf", "/certs", "/home/logstash","/opt/dropwizard/"]

#WORKDIR /home/logstash

CMD ["/bin/bash", "/start.sh"]

EXPOSE 80
EXPOSE 514
EXPOSE 5043
EXPOSE 9292

