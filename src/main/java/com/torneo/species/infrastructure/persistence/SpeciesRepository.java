
package com.torneo.species.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repositorio JPA para Especies.
 */
public interface SpeciesRepository extends JpaRepository<SpeciesEntity, Long> {
    Optional<SpeciesEntity> findByName(String name);
}
