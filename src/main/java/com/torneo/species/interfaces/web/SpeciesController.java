
package com.torneo.species.interfaces.web;

import com.torneo.species.application.SpeciesService;
import com.torneo.species.domain.Species;
import com.torneo.species.interfaces.web.model.CreateSpeciesRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operaciones de Especies.
 */
@RestController
@RequestMapping("/api/species")
@Validated
@CrossOrigin
public class SpeciesController {


    private final SpeciesService service;

    public SpeciesController(SpeciesService service) {
        this.service = service;
    }

    /**
     * Crea una especie.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Species create(@RequestBody CreateSpeciesRequest req) {
        return service.register(req.id(), req.name(), req.powerLevel(), req.specialAbility());
    }

    /**
     * Lista todas las especies.
     */
    @GetMapping
    public List<Species> list() {
        return service.all();
    }
}
