package io.github.akuniutka.charcounter.dto;


public class CharStats {
    private Character character;
    private Long count;

    public CharStats(Character character, Long count) {
        if (character == null && count == null) {
            throw new IllegalArgumentException("both character and count are null");
        } else if (character == null) {
            throw new IllegalArgumentException("charater is null");
        } else if (count == null) {
            throw new IllegalArgumentException("count is null");
        }
        this.character = character;
        this.count = count;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("character is null");
        }
        this.character = character;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        if (count == null) {
            throw new IllegalArgumentException("count is null");
        }
        this.count = count;
    }
}
