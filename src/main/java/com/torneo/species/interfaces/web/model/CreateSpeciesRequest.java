package com.torneo.species.interfaces.web.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateSpeciesRequest(
    @NotBlank Long id,
    @NotBlank String name,
    @Min(0) int powerLevel,
    @NotBlank String specialAbility) {
}
