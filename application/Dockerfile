FROM openjdk:11.0.6-jre

RUN mkdir /simple-application

COPY ./build/libs/simple-application-0.0.1-SNAPSHOT.jar /simple-application/simple-application.jar
COPY entry_point.sh  /simple-application/docker-entrypoint.sh

WORKDIR /simple-application

RUN chmod 0777 /simple-application/docker-entrypoint.sh
CMD ["/simple-application/docker-entrypoint.sh"]
