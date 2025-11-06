
# Species Service

Microservicio para **gestionar especies** del Gran Torneo Galáctico.

## Endpoints
- `POST /api/species` — Crea una especie `{name, powerLevel, specialAbility}`.
- `GET  /api/species` — Lista todas las especies.

## Tech
- Spring Boot 3 (Java 17), H2 + Flyway, EhCache, Swagger (OpenAPI 3).
- Trazas distribuidas con OpenTelemetry (javaagent) + Jaeger.

## Pruebas y cobertura
```bash
mvn -q test jacoco:report
# Ver: target/site/jacoco/index.html
```

## Ejecutar local
```bash
mvn -q spring-boot:run
```
