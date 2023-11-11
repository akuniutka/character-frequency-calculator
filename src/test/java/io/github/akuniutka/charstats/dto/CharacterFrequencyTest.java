package io.github.akuniutka.charstats.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CharacterFrequencyTest {
    @Test
    void testCharacterFrequencyWhenBothCharacterAndFrequencyAreNull() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new CharacterFrequency(null, null)
        );
        assertEquals("both character and frequency are null", e.getMessage());
    }

    @Test
    void testCharacterFrequencyWhenCharacterIsNull() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new CharacterFrequency(null, 1L)
        );
        assertEquals("character is null", e.getMessage());
    }

    @Test
    void testCharacterFrequencyWhenFrequencyIsNull() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new CharacterFrequency("", null)
        );
        assertEquals("frequency is null", e.getMessage());
    }

    @Test
    void testGetCharacter() {
        CharacterFrequency characterFrequency = new CharacterFrequency("a", 1L);
        assertEquals("a", characterFrequency.getCharacter());
    }

    @Test
    void testGetFrequency() {
        CharacterFrequency characterFrequency = new CharacterFrequency("b", 2L);
        assertEquals(2L, characterFrequency.getFrequency());
    }
}