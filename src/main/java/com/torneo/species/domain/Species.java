
package com.torneo.species.domain;

/**
 * Modelo de dominio que representa una Especie en el torneo.
 * @param id identificador
 * @param name nombre de la especie
 * @param powerLevel nivel de poder (entero)
 * @param specialAbility habilidad especial (texto)
 */
public record Species(Long id, String name, int powerLevel, String specialAbility) {}
