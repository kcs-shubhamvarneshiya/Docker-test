FROM openjdk:17 AS build
COPY target/*.jar pdf-spire-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pdf-spire-0.0.1-SNAPSHOT.jar"]