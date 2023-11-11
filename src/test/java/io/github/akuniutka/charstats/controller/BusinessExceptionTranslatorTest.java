package io.github.akuniutka.charstats.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.akuniutka.charstats.dto.ErrorMessage;
import io.github.akuniutka.charstats.service.CharacterFrequencyService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({CharacterFrequencyController.class})
class BusinessExceptionTranslatorTest {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String ERROR_MESSAGE = "input data is null";
    private static final String URL = "/calculateCharacterFrequencies";
    @Autowired
    private MockMvc mvc;
    @MockBean
    private CharacterFrequencyService service;

    @AfterEach
    public void tearDown() {
        verifyNoInteractions(service);
    }

    @Test
    void testTranslateBadInputDataExceptionWhenJsonEmpty() throws Exception {
        ErrorMessage errorMessage = new ErrorMessage(-1, ERROR_MESSAGE);
        String expected = OBJECT_MAPPER.writeValueAsString(errorMessage);
        mvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{}")
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected, true));
    }

    @Test
    void testTranslateBadInputDataExceptionWhenJsonDoesNotContainData() throws Exception {
        ErrorMessage errorMessage = new ErrorMessage(-1, ERROR_MESSAGE);
        String expected = OBJECT_MAPPER.writeValueAsString(errorMessage);
        mvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"string\": \"0123456789\"}")
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected, true));
    }

    @Test
    void testTranslateBadInputDataExceptionWhenJsonContainsNullData() throws Exception {
        ErrorMessage errorMessage = new ErrorMessage(-1, ERROR_MESSAGE);
        String expected = OBJECT_MAPPER.writeValueAsString(errorMessage);
        mvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"data\": null}")
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected, true));
    }
}