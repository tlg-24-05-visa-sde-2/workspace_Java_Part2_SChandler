package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private SalariedEmployee emp;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
        emp = new SalariedEmployee("John", Date.valueOf("2024-05-13"), 1500.00);
        emp2 = new SalariedEmployee("John", Date.valueOf("2024-05-13"), 1500.00);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHiredDate_sameSalary() {
        emp2.setName("Lee");
    }

    @Test
    public void equals_shouldReturnFalse_same_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2024-05-03"));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1299.0);
        assertNotEquals(emp, emp2);
        assertFalse(emp.equals(emp2));
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp, emp);   // assertEquals() for objects does a .equals() check
        assertTrue(emp.equals(emp));   // alternative
    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.0, emp.payTaxes(), .001);      // 30% of the salary
    }

    @Test
    public void testPay() {
        assertEquals(1500.0, emp.pay(), .001);       // fixed salary
    }
}
