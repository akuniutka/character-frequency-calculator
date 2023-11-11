package io.github.akuniutka.charcounter.dto;


public class CharStats {
    private String character;
    private Long count;

    public CharStats(String character, Long count) {
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

    public String getCharacter() {
        return character;
    }

    public Long getCount() {
        return count;
    }
}
