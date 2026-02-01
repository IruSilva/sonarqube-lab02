package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator c = new Calculator();
        assertEquals(15, c.calculate(10,5,"add"));
    }

    @Test
    void testSub() {
        Calculator c = new Calculator();
        assertEquals(5, c.calculate(10,5,"sub"));
    }

    @Test
    void testMul() {
        Calculator c = new Calculator();
        assertEquals(50, c.calculate(10,5,"mul"));
    }

    @Test
    void testDiv() {
        Calculator c = new Calculator();
        assertEquals(2, c.calculate(10,5,"div"));
    }

    @Test
    void testPow() {
        Calculator c = new Calculator();
        assertEquals(1000, c.calculate(10,3,"pow"));
    }
}
