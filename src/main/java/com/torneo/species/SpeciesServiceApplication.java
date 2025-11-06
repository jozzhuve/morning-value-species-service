
package com.torneo.species;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada del microservicio de Especies.
 *
 * <p>Expone endpoints para registrar y listar especies del Torneo Galáctico.
 * Persistencia en H2 con migraciones Flyway, caché con EhCache, documentación OpenAPI,
 * e instrumentación de trazas con OpenTelemetry (javaagent).</p>
 */
@SpringBootApplication
public class SpeciesServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpeciesServiceApplication.class, args);
    }
}
