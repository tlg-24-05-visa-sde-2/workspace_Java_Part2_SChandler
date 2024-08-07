/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 * This is the contract:
 */
package com.javatunes.billing;

public interface TaxCalculator {
    public double taxAmount(double taxable);
}