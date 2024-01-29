FROM openjdk:11 AS build
COPY target/*.jar pdf-spire-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "pdf-spire-0.0.1-SNAPSHOT.jar"]