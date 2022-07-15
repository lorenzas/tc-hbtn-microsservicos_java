package com.example.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        assertEquals(10, calculator.sum(5.0, 5.0));
    }

    @Test
    public void numbersNullSumTest() {
        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            calculator.sum(5.0, null);
        });

        Assertions.assertEquals("Número 1 e número 2 são obrigatórios.", thrown.getMessage());
    }

    @Test
    void subTest() {
        assertEquals(10, calculator.sub(15.0, 5.0));
    }

    @Test
    void divideTest() {
        assertEquals(3, calculator.divide(15.0, 5.0));
    }

    @Test
    public void divisionByZeroTest() {
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5.0, 0.0);
        });

        Assertions.assertEquals("Divisão por zero não é permitido.", thrown.getMessage());
    }

    @Test
    void factorialTest() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(10100, calculator.integerToBinary(20));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("AA", calculator.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
        assertEquals(20, calculator.calculeDayBetweenDate(LocalDate.of(2000, 5, 10), LocalDate.of(2000, 5, 30)));
    }
}

