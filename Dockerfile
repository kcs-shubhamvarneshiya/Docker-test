FROM openjdk:11

WORKDIR /src

COPY target/pdf-spire-0.0.1-SNAPSHOT.jar /src/

EXPOSE 8080

CMD ["java", "-jar", "pdf-spire-0.0.1-SNAPSHOT.jar"]
