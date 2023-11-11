package io.github.akuniutka.charstats.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BadInputDataExceptionTest {
    private static final String ERROR_MESSAGE = "input data is null";

    @Test
    void testBadInputDataException() {
        Exception e = assertThrows(BadInputDataException.class, () -> {
            throw new BadInputDataException(ERROR_MESSAGE);
        });
        assertEquals(ERROR_MESSAGE, e.getMessage());
    }
}