
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /app
# Otel Java Agent
RUN mkdir -p /otel && curl -sSL -o /otel/opentelemetry-javaagent.jar https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v2.8.0/opentelemetry-javaagent.jar
COPY --from=build /app/target/species-service-*.jar /app/app.jar
VOLUME ["/data"]
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar","--server.port=8081"]
