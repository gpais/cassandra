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
    rm -rf /var/lib/apt/lists/* 


# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

RUN mkdir /opt/dropwizard
RUN mkdir -p /etc/pki/tls/certs
RUN mkdir -p /etc/pki/tls/private

ADD config.yml /opt/dropwizard/config.yml
COPY target/com.LetsGetDigitalCassandra-0.0.1-SNAPSHOT.jar /opt/dropwizard/
WORKDIR /opt/dropwizard
#RUN java -jar com.LetsGetDigitalCassandra-0.0.1-SNAPSHOT.jar db migrate config.yml


ADD start.sh  /start.sh



RUN chmod 755 /start.sh

VOLUME ["/opt/dropwizard/","/var/log/"]

#WORKDIR /home/logstash
CMD ["/bin/bash", "/start.sh"]

run echo "asdasd 2"
EXPOSE 80
EXPOSE 514
EXPOSE 5043
EXPOSE 9292
EXPOSE 9160
EXPOSE 9042

