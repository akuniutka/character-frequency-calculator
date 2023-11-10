package io.github.akuniutka.charcounter.controller;

import io.github.akuniutka.charcounter.dto.CharStats;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CharCounterController {
    @GetMapping("/getCharStats")
    @Operation(summary = "Returns counts for every char in the input string")
    public List<CharStats> getCharStats() {
        List<CharStats> stats = new ArrayList<>();
        stats.add(new CharStats('a', 1L));
        return stats;
    }
}
