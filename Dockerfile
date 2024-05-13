FROM openjdk:17-jdk-alpine

ENV JAVA_OPTS=""

COPY target/apirestprodutos-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar

COPY src/main/resources/application.properties application.properties