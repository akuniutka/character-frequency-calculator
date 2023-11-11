package io.github.akuniutka.charcounter.service;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterServiceTest {
    @Test
    void testGetCharacterFrequenciesWhenStringIsNotNull() {
        String string = "Hello, World!";
        String[] expectedCharacters = {"l", "o", " ", "!", ",", "H", "W", "d", "e", "r"};
        long[] expectedFrequencies = {3L, 2L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L};
        int i = 0;
        CharCounterService service = new CharCounterService();
        Map<String, Long> characterFrequencies = service.getCharacterFrequencies(string);
        for (Map.Entry<String, Long> entry : characterFrequencies.entrySet()) {
            assertEquals(expectedCharacters[i], entry.getKey());
            assertEquals(expectedFrequencies[i], entry.getValue());
            ++i;
        }
    }
}