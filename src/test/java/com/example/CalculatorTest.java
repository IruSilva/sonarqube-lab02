package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void shouldReturnZeroWhenOpIsNull() {
        assertEquals(0, calc.calculate(10, 5, null));
    }

    @Test
    void shouldAdd() {
        assertEquals(15, calc.calculate(10, 5, "add"));
    }

    @Test
    void shouldAddAgainOp() {
        assertEquals(15, calc.calculate(10, 5, "add-again"));
    }

    @Test
    void shouldSubtract() {
        assertEquals(5, calc.calculate(10, 5, "sub"));
    }

    @Test
    void shouldSubtractAgainOp() {
        assertEquals(5, calc.calculate(10, 5, "sub-again"));
    }

    @Test
    void shouldMultiply() {
        assertEquals(50, calc.calculate(10, 5, "mul"));
    }

    @Test
    void shouldDivide() {
        assertEquals(2, calc.calculate(10, 5, "div"));
    }

    @Test
    void shouldReturnZeroWhenDivideByZero() {
        assertEquals(0, calc.calculate(10, 0, "div"));
    }

    @Test
    void shouldDivideNegativeNumbers() {
        assertEquals(-2, calc.calculate(-10, 5, "div"));
    }

    @Test
    void shouldModWithZeroRemainder() {
        assertEquals(0, calc.calculate(10, 5, "mod"));
    }

    @Test
    void shouldModWithNonZeroRemainder() {
        assertEquals(1, calc.calculate(10, 3, "mod"));
    }

    @Test
    void shouldPowPositiveExponent() {
        assertEquals(1000, calc.calculate(10, 3, "pow"));
    }

    @Test
    void shouldPowZeroExponent() {
        // loop not entered, should return initial result = 1
        assertEquals(1, calc.calculate(10, 0, "pow"));
    }

    @Test
    void shouldPowNegativeExponentReturnsOneInThisImplementation() {
        // loop not entered because i < b is false when b is negative
        assertEquals(1, calc.calculate(10, -2, "pow"));
    }

    @Test
    void shouldReturnZeroForUnknownOp() {
        assertEquals(0, calc.calculate(10, 5, "anything"));
    }

    @Test
    void shouldTestAddAgainMethodToo() {
        assertEquals(15, calc.addAgain(10, 5));
    }
}
