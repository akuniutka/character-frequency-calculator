package io.github.akuniutka.charstats.controller;

import io.github.akuniutka.charstats.dto.CharacterFrequency;
import io.github.akuniutka.charstats.dto.InputData;
import io.github.akuniutka.charstats.exception.BadInputDataException;
import io.github.akuniutka.charstats.service.CharacterFrequencyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterFrequencyController {
    private final CharacterFrequencyService service;

    public CharacterFrequencyController(CharacterFrequencyService service) {
        this.service = service;
    }

    @PostMapping("/calculateCharacterFrequencies")
    @Operation(summary = "Calculates frequency for characters in the input string.")
    public List<CharacterFrequency> calculateCharacterFrequencies(@RequestBody InputData inputData) {
        if (inputData == null || inputData.getData() == null) {
            throw new BadInputDataException("input data is null");
        }
        return service.getCharacterFrequencies(inputData.getData());
    }
}
