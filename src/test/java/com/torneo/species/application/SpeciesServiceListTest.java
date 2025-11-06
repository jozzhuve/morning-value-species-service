
package com.torneo.species.application;

import com.torneo.species.infrastructure.persistence.SpeciesEntity;
import com.torneo.species.infrastructure.persistence.SpeciesRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SpeciesServiceListTest {

    @Test
    void all_should_map_entities_to_domain() {
        SpeciesRepository repo = mock(SpeciesRepository.class);
        SpeciesService service = new SpeciesService(repo);

        SpeciesEntity e1 = new SpeciesEntity();
        e1.setId(1L); e1.setName("A"); e1.setPowerLevel(1); e1.setSpecialAbility("x");
        SpeciesEntity e2 = new SpeciesEntity();
        e2.setId(2L); e2.setName("B"); e2.setPowerLevel(2); e2.setSpecialAbility("y");

        when(repo.findAll()).thenReturn(List.of(e1, e2));

        var list = service.all();
        assertEquals(2, list.size());
        assertEquals("A", list.get(0).name());
        assertEquals(2, list.get(1).powerLevel());
    }
}
