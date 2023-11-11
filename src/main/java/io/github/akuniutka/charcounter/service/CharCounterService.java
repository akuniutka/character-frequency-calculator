package io.github.akuniutka.charcounter.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CharCounterService {
    public Map<String, Long> getCharacterFrequencies(String string) {
        return string.codePoints()
                .mapToObj(cp -> String.valueOf(Character.toChars(cp)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
//                .collect(Collectors.toMap(
//                        Function.identity(),
//                        s -> 1L,
//                        Long::sum
//                )).entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> b,
                        LinkedHashMap::new
                ));
    }
}
