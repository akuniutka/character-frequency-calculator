package io.github.akuniutka.charstats.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.akuniutka.charstats.dto.CharacterFrequency;
import io.github.akuniutka.charstats.dto.InputData;
import io.github.akuniutka.charstats.service.CharacterFrequencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({CharacterFrequencyController.class})
class CharacterFrequencyControllerTest {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String URL = "/calculateCharacterFrequencies";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CharacterFrequencyService service;

    @Test
    void testCharacterFrequencyController() {
        assertDoesNotThrow(() -> new CharacterFrequencyController(service));
    }

    @Test
    void testCalculateCharacterFrequenciesWhenStringIsNotEmpty() throws Exception {
        List<CharacterFrequency> characterFrequencies = new ArrayList<>();
        characterFrequencies.add(new CharacterFrequency("a", 10L));
        characterFrequencies.add(new CharacterFrequency("b", 9L));
        characterFrequencies.add(new CharacterFrequency("c", 8L));
        String expected = OBJECT_MAPPER.writeValueAsString(characterFrequencies);
        String testString = "abc";
        InputData inputData = new InputData();
        inputData.setData(testString);
        String requestBody = OBJECT_MAPPER.writeValueAsString(inputData);
        when(service.getCharacterFrequencies(testString)).thenReturn(characterFrequencies);
        mvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected, true));
        verify(service).getCharacterFrequencies(testString);
        verifyNoMoreInteractions(ignoreStubs(service));
    }

    @Test
    void testCalculateCharacterFrequenciesWhenStringIsEmpty() throws Exception {
        List<CharacterFrequency> characterFrequencies = new ArrayList<>();
        String expected = OBJECT_MAPPER.writeValueAsString(characterFrequencies);
        String testString = "";
        InputData inputData = new InputData();
        inputData.setData(testString);
        String requestBody = OBJECT_MAPPER.writeValueAsString(inputData);
        when(service.getCharacterFrequencies(testString)).thenReturn(characterFrequencies);
        mvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected, true));
        verify(service).getCharacterFrequencies(testString);
        verifyNoMoreInteractions(ignoreStubs(service));
    }
}