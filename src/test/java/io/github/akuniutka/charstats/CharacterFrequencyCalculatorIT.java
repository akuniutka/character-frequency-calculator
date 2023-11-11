package io.github.akuniutka.charstats;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.akuniutka.charstats.dto.CharacterFrequency;
import io.github.akuniutka.charstats.dto.ErrorMessage;
import io.github.akuniutka.charstats.dto.InputData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CharacterFrequencyCalculatorIT {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String ERROR_MESSAGE = "input data is null";
    private static final String URL = "/calculateCharacterFrequencies";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCalculateCharacterFrequenciesWhenJsonIsEmpty() throws Exception {
        ErrorMessage errorMessage = new ErrorMessage(-1, ERROR_MESSAGE);
        String expected = OBJECT_MAPPER.writeValueAsString(errorMessage);
        webTestClient.post()
                .uri(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue("{}")
                .exchange()
                .expectStatus().isBadRequest()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().json(expected, true);
    }

    @Test
    void testCalculateCharacterFrequenciesWhenJsonDoesNotContainData() throws Exception {
        ErrorMessage errorMessage = new ErrorMessage(-1, ERROR_MESSAGE);
        String expected = OBJECT_MAPPER.writeValueAsString(errorMessage);
        webTestClient.post()
                .uri(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue("{\"string\": \"0123456789\"}")
                .exchange()
                .expectStatus().isBadRequest()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().json(expected, true);
    }

    @Test
    void testCalculateCharacterFrequenciesWhenJsonContainsNullData() throws Exception {
        ErrorMessage errorMessage = new ErrorMessage(-1, ERROR_MESSAGE);
        String expected = OBJECT_MAPPER.writeValueAsString(errorMessage);
        webTestClient.post()
                .uri(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue("{\"data\": null}")
                .exchange()
                .expectStatus().isBadRequest()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().json(expected, true);
    }

    @Test
    void testCalculateCharacterFrequenciesWhenStringIsNotEmpty() throws Exception {
        List<CharacterFrequency> characterFrequencies = new ArrayList<>();
        characterFrequencies.add(new CharacterFrequency("l", 3L));
        characterFrequencies.add(new CharacterFrequency("o", 2L));
        characterFrequencies.add(new CharacterFrequency(" ", 1L));
        characterFrequencies.add(new CharacterFrequency("!", 1L));
        characterFrequencies.add(new CharacterFrequency(",", 1L));
        characterFrequencies.add(new CharacterFrequency("H", 1L));
        characterFrequencies.add(new CharacterFrequency("W", 1L));
        characterFrequencies.add(new CharacterFrequency("d", 1L));
        characterFrequencies.add(new CharacterFrequency("e", 1L));
        characterFrequencies.add(new CharacterFrequency("r", 1L));
        String expected = OBJECT_MAPPER.writeValueAsString(characterFrequencies);
        InputData inputData = new InputData();
        inputData.setData("Hello, World!");
        webTestClient.post()
                .uri(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(inputData)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().json(expected, true);
    }

    @Test
    void testCalculateCharacterFrequenciesWhenStringIsEmpty() throws Exception {
        List<CharacterFrequency> characterFrequencies = new ArrayList<>();
        String expected = OBJECT_MAPPER.writeValueAsString(characterFrequencies);
        InputData inputData = new InputData();
        inputData.setData("");
        webTestClient.post()
                .uri(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(inputData)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().json(expected, true);
    }
}