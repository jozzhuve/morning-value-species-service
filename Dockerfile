FROM eclipse-temurin:21-jre

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/app.jar

# Agente de OpenTelemetry (montado por volumen)
ENV JAVA_TOOL_OPTIONS="-javaagent:/otel/opentelemetry-javaagent.jar"

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
