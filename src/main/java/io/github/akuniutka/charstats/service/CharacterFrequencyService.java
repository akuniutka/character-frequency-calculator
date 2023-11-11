package io.github.akuniutka.charstats.service;

import io.github.akuniutka.charstats.dto.CharacterFrequency;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CharacterFrequencyService {
    private static final Comparator<CharacterFrequency> COMPARATOR = Comparator
            .comparing(CharacterFrequency::getFrequency)
            .reversed()
            .thenComparing(CharacterFrequency::getCharacter);

    public List<CharacterFrequency> getCharacterFrequencies(String string) {
        return string.codePoints()
                .mapToObj(cp -> String.valueOf(Character.toChars(cp)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(entry -> new CharacterFrequency(entry.getKey(), entry.getValue()))
                .sorted(COMPARATOR)
                .collect(Collectors.toList());
    }
}
