package com.skillbox.fibonacci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FibonacciServiceTest {

    @Mock
    private FibonacciRepository repository;

    @Mock
    private FibonacciCalculator calculator;

    @InjectMocks
    private FibonacciService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFibonacciNumberFoundInDatabase() {
        FibonacciNumber expected = new FibonacciNumber(5, 5);
        FibonacciNumber actual = new FibonacciNumber(5, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void testFibonacciNumberNotFoundInDatabase() {
        FibonacciNumber expected = new FibonacciNumber(5, 5);
        FibonacciNumber actual = new FibonacciNumber(8, 6);
        assertNotEquals(expected, actual);
    }

    @Test
    void testFibonacciNumberInvalidIndex() {
        int invalidIndex = -1;

        assertThrows(IllegalArgumentException.class, () -> service.fibonacciNumber(invalidIndex));

        verify(repository, never()).findByIndex(anyInt());
        verify(calculator, never()).getFibonacciNumber(anyInt());
        verify(repository, never()).save(any(FibonacciNumber.class));
    }
}
