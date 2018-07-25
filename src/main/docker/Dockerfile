FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE

COPY ${JAR_FILE} dockerize-app-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dockerize-app-0.0.1-SNAPSHOT.jar"]