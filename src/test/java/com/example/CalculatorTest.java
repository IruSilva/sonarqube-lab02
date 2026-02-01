package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void shouldAdd() {
        assertEquals(15, calc.calculate(10, 5, "add"));
    }

    @Test
    void shouldAddAgain() {
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
    void shouldMod() {
        assertEquals(0, calc.calculate(10, 5, "mod"));
    }

    @Test
    void shouldPow() {
        assertEquals(1000, calc.calculate(10, 3, "pow"));
    }

    @Test
    void shouldReturnZeroForUnknownOp() {
        assertEquals(0, calc.calculate(10, 5, "anything"));
    }
}
