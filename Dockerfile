FROM openjdk:11

WORKDIR /app

COPY target/solr-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "solr-0.0.1-SNAPSHOT.jar"]