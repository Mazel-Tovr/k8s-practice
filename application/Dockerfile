FROM openjdk:11.0.6-jre

RUN mkdir /simple-application

COPY ./build/libs/simple-application-0.0.1-SNAPSHOT.jar /simple-application/simple-application.jar

WORKDIR /simple-application

CMD ["java", "-server", "-jar", "simple-application.jar", "--spring.profiles.active=docker"]
