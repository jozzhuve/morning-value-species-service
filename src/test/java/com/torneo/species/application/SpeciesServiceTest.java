
package com.torneo.species.application;

import com.torneo.species.infrastructure.persistence.SpeciesEntity;
import com.torneo.species.infrastructure.persistence.SpeciesRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SpeciesServiceTest {

    @Test
    void register_should_persist_and_return_domain() {
        SpeciesRepository repo = mock(SpeciesRepository.class);
        SpeciesService service = new SpeciesService(repo);

        SpeciesEntity saved = new SpeciesEntity();
        saved.setId(1L);
        saved.setName("Zorgon");
        saved.setPowerLevel(9000);
        saved.setSpecialAbility("Rayos láser");

        when(repo.save(any())).thenReturn(saved);

        var result = service.register(1L,"Zorgon", 9000, "Rayos láser");

        ArgumentCaptor<SpeciesEntity> cap = ArgumentCaptor.forClass(SpeciesEntity.class);
        verify(repo).save(cap.capture());
        assertEquals("Zorgon", cap.getValue().getName());
        assertEquals(1L, result.id());
        assertEquals(9000, result.powerLevel());
    }
}
