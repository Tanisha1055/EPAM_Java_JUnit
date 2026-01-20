package org.child1.JUnitTesting.service.ParameterizedTesting;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@ValueSource
//Purpose: Supplies a simple array of literal values (like ints, strings, etc.).
//Usage: Great for basic types and simple cases.
//This test will run four times, once for each number.
public class ValueSourceType {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void testIsEven(int number) {
        assertTrue(number % 2 == 0);
    }
}
