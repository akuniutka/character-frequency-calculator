package io.github.akuniutka.charstats.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputDataTest {
    @Test
    void testSetDataAndGetData() {
        InputData inputData = new InputData();
        assertNull(inputData.getData());
        assertDoesNotThrow(() -> inputData.setData("Hello, World!"));
        assertEquals("Hello, World!", inputData.getData());
    }
}