package org.child1.JUnitTesting.service.ParameterizedTesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@MethodSource
//Purpose: Supplies arguments from a static method in your test class (or another class).
//Usage: Use when you need to generate or fetch test data dynamically, or when the data is complex.
//Here, numberProvider returns a stream of arguments for the test.
//It has more reusability as we are passing function which we can pass any time to any other
//MethodSource function .
//It also supports primitives and Strings unlike CSVSource
public class MethodSourceType {
    @ParameterizedTest
    @MethodSource("numberProvider")
    void testIsEven(int number, boolean expected) {
        assertEquals(expected, number % 2 == 0);
    }

    static Stream<Arguments> numberProvider() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(3, false),
                Arguments.of(4, true)
        );
    }
}
