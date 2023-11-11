package io.github.akuniutka.charstats.service;

import io.github.akuniutka.charstats.dto.CharacterFrequency;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterFrequencyServiceTest {
    @Test
    void testGetCharacterFrequenciesWhenStringIsNotEmpty() {
        String string = "Hello, World!";
        String[] expectedCharacters = {"l", "o", " ", "!", ",", "H", "W", "d", "e", "r"};
        long[] expectedFrequencies = {3L, 2L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L};
        int i = 0;
        CharacterFrequencyService service = new CharacterFrequencyService();
        List<CharacterFrequency> characterFrequencies = service.getCharacterFrequencies(string);
        assertEquals(expectedCharacters.length, characterFrequencies.size());
        for (CharacterFrequency characterFrequency : characterFrequencies) {
            assertEquals(expectedCharacters[i], characterFrequency.getCharacter());
            assertEquals(expectedFrequencies[i], characterFrequency.getFrequency());
            ++i;
        }
    }

    @Test
    void testGetCharacterFrequenciesWhenStringIsEmpty() {
        String string = "";
        CharacterFrequencyService service = new CharacterFrequencyService();
        List<CharacterFrequency> characterFrequencies = service.getCharacterFrequencies(string);
        assertNotNull(characterFrequencies);
        assertTrue(characterFrequencies.isEmpty());
    }
}