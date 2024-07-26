package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
        emp1 = getEmployee();
        emp2 = getEmployee();

        // emp1 = new DummyEmployee("Sherie", Date.valueOf("1997-06-2"));
        // emp2 = new DummyEmployee("Sherie", Date.valueOf("1997-06-4"));
    }

    private static Employee getEmployee() {
        return new Employee("Jay", Date.valueOf("1960-05-14")) {
            public double pay() { return 0; }
            public double payTaxes() { return 0; }
        };
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("Sherie");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2018-09-12"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_sameName_sameHireDate() {
        assertEquals(emp1, emp2);
    }

    //NAMED MEMBER-LEVEL INNER CLASSES
    //this is called a "mock" a fake business type just for testing
    private class DummyEmployee extends Employee {

        public DummyEmployee() {
        }

        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }
}
