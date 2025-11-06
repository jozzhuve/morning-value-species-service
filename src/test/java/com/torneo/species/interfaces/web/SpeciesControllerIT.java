package com.torneo.species.interfaces.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpeciesControllerIT {

    @Autowired
    MockMvc mockMvc;

    private String readResource(String path) throws IOException {
        try (var is = getClass().getResourceAsStream(path)) {
            if (is == null) throw new IOException("Recurso no encontrado: " + path);
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    @Test
    @Order(1)
    @DisplayName("🧪 Crear especie — 201 (AAA)")
    void create_species_from_payloadJson_201() throws Exception {
        // Arrange
        String payload = readResource("/payloads/species-create.json");

        // Act & Assert
        mockMvc.perform(post("/api/species")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").value("Aldoran"));
    }

    @Test
    @Order(2)
    @DisplayName("🧪 Listar especies — 200 (AAA)")
    void list_species_200() throws Exception {
        // Arrange
        // (sin precondiciones adicionales)

        // Act & Assert
        mockMvc.perform(get("/api/species"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").exists());
    }
}
