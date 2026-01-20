package org.child1.JUnitTesting.service.TestExceptionDocumentation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionIsNotThrown {
    @Test
    void givenBlock_whenExecutes_thenEnsureNoExceptionIsThrown() {
        assertDoesNotThrow(() -> {
            int i = 100 / 10; // safe
        });
    }
    //Different way of testing
    @Test
    void ensureIllegalArgumentExceptionIsNotThrown() {
        assertThrows(ArithmeticException.class, () -> {
            int i = 100 / 0;
        });
    }
}
