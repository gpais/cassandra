#!/bin/bash
echo run this.
#/bin/bash -c -v "java -jar /opt/dropwizard/LetsGetDigital-0.0.1-SNAPSHOT.jar server /opt/dropwizard/config_aws.yml"
#/bin/sh -c "java -jar /opt/dropwizard/LetsGetDigital-0.0.1-SNAPSHOT.jar server /opt/dropwizard/config_aws.yml"
/bin/sh -c "java -jar /opt/dropwizard/LetsGetDigital-0.0.1-SNAPSHOT.jar server /opt/dropwizard/config_aws.yml & logstash-forwarder -config=/etc/logstash-forwarder.conf"