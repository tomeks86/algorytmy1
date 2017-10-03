package com.company.company.employees;

public class TemporaryEmployee extends Employee {
    public TemporaryEmployee(double grossSalary, String email) {
        super(grossSalary, 10., email);
    }

    @Override
    public String toString() {
        return "temporary employee";
    }
}
