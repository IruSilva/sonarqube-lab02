package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(15, calc.calculate(10, 5, "add"));
    }

    @Test
    void testSub() {
        assertEquals(5, calc.calculate(10, 5, "sub"));
    }

    @Test
    void testMul() {
        assertEquals(50, calc.calculate(10, 5, "mul"));
    }

    @Test
    void testDiv() {
        assertEquals(2, calc.calculate(10, 5, "div"));
    }

    @Test
    void testDivByZero() {
        assertEquals(0, calc.calculate(10, 0, "div"));
    }

    @Test
    void testMod() {
        assertEquals(0, calc.calculate(10, 5, "mod"));
    }

    @Test
    void testPow() {
        assertEquals(100, calc.calculate(10, 2, "pow"));
    }

    @Test
    void testDefault() {
        assertEquals(0, calc.calculate(10, 5, "unknown"));
    }
}
