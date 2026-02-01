package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void shouldAddAgainUsingCalculate() {
        assertEquals(15, calc.calculate(10, 5, "add-again"));
    }

    @Test
    void shouldSubtract() {
        assertEquals(5, calc.calculate(10, 5, "sub"));
    }

    @Test
    void shouldSubtractAgain() {
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
    void shouldModWhenEvenlyDivisible() {
        assertEquals(0, calc.calculate(10, 5, "mod"));
    }

    @Test
    void shouldModWhenNotEvenlyDivisible() {
        assertEquals(1, calc.calculate(10, 3, "mod"));
    }

    @Test
    void shouldPowWithPositiveExponent() {
        assertEquals(1000, calc.calculate(10, 3, "pow"));
    }

    @Test
    void shouldPowWithZeroExponent() {
        assertEquals(1, calc.calculate(10, 0, "pow"));
    }

    @Test
    void shouldPowWithNegativeExponentGivesDefaultResult() {
        // your current implementation loops from 0 to b; if b is negative, loop won't run
        // so result stays 1
        assertEquals(1, calc.calculate(10, -3, "pow"));
    }

    @Test
    void shouldReturnZeroForUnknownOperation() {
        assertEquals(0, calc.calculate(10, 5, "unknown"));
    }

    @Test
    void shouldCoverAddAgainMethodDirectly() {
        assertEquals(15, calc.addAgain(10, 5));
    }

    @Test
    void shouldHandleNegativeNumbers() {
        assertEquals(-5, calc.calculate(-10, 5, "add"));
        assertEquals(-15, calc.calculate(-10, 5, "sub"));
        assertEquals(-50, calc.calculate(-10, 5, "mul"));
    }

    @Test
    void shouldHandleDivisionWithNegative() {
        assertEquals(-2, calc.calculate(-10, 5, "div"));
        assertEquals(2, calc.calculate(-10, -5, "div"));
    }
}
