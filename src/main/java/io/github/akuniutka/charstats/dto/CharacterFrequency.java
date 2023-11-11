package io.github.akuniutka.charstats.dto;


public class CharacterFrequency {
    private final String character;
    private final Long frequency;

    public CharacterFrequency(String character, Long frequency) {
        if (character == null && frequency == null) {
            throw new IllegalArgumentException("both character and frequency are null");
        } else if (character == null) {
            throw new IllegalArgumentException("character is null");
        } else if (frequency == null) {
            throw new IllegalArgumentException("frequency is null");
        }
        this.character = character;
        this.frequency = frequency;
    }

    public String getCharacter() {
        return character;
    }

    public Long getFrequency() {
        return frequency;
    }
}
