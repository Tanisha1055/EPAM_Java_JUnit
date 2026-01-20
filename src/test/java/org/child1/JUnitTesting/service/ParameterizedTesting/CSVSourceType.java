package org.child1.JUnitTesting.service.ParameterizedTesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@CsvSource
//Purpose: Supplies multiple sets of arguments using comma-separated values (CSV).
//Usage: Useful when you want to pass multiple parameters per test run.
//This test runs three times, each time with a pair of values.
public class CSVSourceType {
    @ParameterizedTest
    @CsvSource({
            "2, true",
            "3, false",
            "4, true"
    })
    void testIsEven(int number, boolean expected) {
        assertEquals(expected, number % 2 == 0);
    }
}
