
package com.torneo.species.application;

import com.torneo.species.domain.Species;
import com.torneo.species.infrastructure.persistence.SpeciesEntity;
import com.torneo.species.infrastructure.persistence.SpeciesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio de aplicación para casos de uso de Especies.
 */
@Service
@Transactional
public class SpeciesService {

    private final SpeciesRepository repository;

    public SpeciesService(SpeciesRepository repository) {
        this.repository = repository;
    }

    /**
     * Registra una nueva especie.
     *
     * @param name           nombre
     * @param powerLevel     nivel de poder
     * @param specialAbility habilidad especial
     * @return especie creada
     */
    public Species register(Long id, String name, int powerLevel, String specialAbility) {
        SpeciesEntity speciesEntity = new SpeciesEntity();
        speciesEntity.setId(id);
        speciesEntity.setName(name);
        speciesEntity.setPowerLevel(powerLevel);
        speciesEntity.setSpecialAbility(specialAbility);
        speciesEntity = repository.save(speciesEntity);
        return new Species(
            speciesEntity.getId(),
            speciesEntity.getName(),
            speciesEntity.getPowerLevel(),
            speciesEntity.getSpecialAbility()
        );
    }

    /**
     * Retorna todas las especies registradas (con <b>caché EhCache</b>).
     * <p>La caché se invalida al registrar.</p>
     */
    @Transactional(readOnly = true)
    public List<Species> all() {
        return repository.findAll().stream()
            .map(e -> new Species(e.getId(), e.getName(), e.getPowerLevel(), e.getSpecialAbility()))
            .toList();
    }
}
