#!/bin/bash -e

MQ_JKS_PASSWORD='password'

if [[ -n "${jasypt_key}" ]]; then
  echo "i am here ${jasypt_key}"
  MQ_JKS_PASSWORD="new ${MQ_JKS_PASSWORD} ${jasypt_key}"
fi

javaArguments=''
export JAVA_OPTS="${JAVA_OPTS} ${javaArguments}"
export LANG=en_US.UTF-8

java \
-Djasypt.encryptor.password="${jasypt_key}" \
-Djavax.net.ssl.keyStore="/etc/config/ssl/mq.jks" \
-Djavax.net.ssl.keyStorePassword="${MQ_JKS_PASSWORD}" \
-Djavax.net.ssl.trustStore="/etc/config/ssl/mq.jks" \
-Djavax.net.ssl.trustStorePassword="${MQ_JKS_PASSWORD}" \
-Djava.net.preferIPv4Addresses=true \
-Djava.net.preferIPv4Stack=true \
-Dspring.profiles.active=PROM,COMMON \
$JAVA_OPTS \
-jar simple-application.jar
