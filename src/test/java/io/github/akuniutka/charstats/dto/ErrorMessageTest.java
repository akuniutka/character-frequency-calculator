package io.github.akuniutka.charstats.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorMessageTest {
    @Test
    void testErrorMessageWhenMessageIsNull() {
        assertDoesNotThrow(() -> new ErrorMessage(-1, null));
    }

    @Test
    void testErrorMessageWhenMessageIsNotNull() {
        assertDoesNotThrow(() -> new ErrorMessage(-1, "wrong data"));
    }

    @Test
    void testGetStatus() {
        ErrorMessage errorMessage = new ErrorMessage(-1, "wrong data");
        assertEquals(-1, errorMessage.getStatus());
    }

    @Test
    void testGetMessage() {
        ErrorMessage errorMessage = new ErrorMessage(-2, "error");
        assertEquals("error", errorMessage.getMessage());
    }
}