FROM openjdk:11

WORKDIR /src

COPY target/pdf-spire-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "my-java-app.jar"]
