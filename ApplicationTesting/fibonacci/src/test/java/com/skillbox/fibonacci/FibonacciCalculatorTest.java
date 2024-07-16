package com.skillbox.fibonacci;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciCalculatorTest {

    private final FibonacciCalculator calculator = new FibonacciCalculator();

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "7, 13",
            "8, 21",
            "9, 34",
            "10, 55"
    })
    void testGetFibonacciNumber(int index, int expected) {
        assertEquals(expected, calculator.getFibonacciNumber(index));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5, -10})
    void testGetFibonacciNumberWithInvalidIndex(int index) {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                calculator.getFibonacciNumber(index);
            }
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void testGetFibonacciNumberForOneAndTwo(int index) {
        assertEquals(1, calculator.getFibonacciNumber(index));
    }
}

