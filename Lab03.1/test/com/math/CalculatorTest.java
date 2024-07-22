/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    // Business Objects(s) under test-called the "fixture".
    private Calculator calc;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void testIsEven() {
        System.out.println("isEven");
        assertTrue(calc.isEven(10));
        assertTrue(calc.isEven(11));
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide");
        assertEquals(2.5, calc.divide(5, 2), 0.001); // expected, actual, delta
    }

    @Test
    public void testAdd() {
        System.out.println("testAdd");
        assertEquals(5, calc.add(1, 4)); // expected, actual
    }
}
