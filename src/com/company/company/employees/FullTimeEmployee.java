package com.company.company.employees;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(double grossSalary, String email) {
        super(grossSalary, 20., email);
        if (grossSalary < 2000) {
            System.out.println("Brutto salary increased by 1000");
            setGrossSalary(grossSalary + 1000);
        }
    }

    @Override
    public double calculateNetSalary() {
        return (getGrossSalary() - 1000) / (1. + getTaxRate() / 100.);  //1000 from brutto salary to insurance
        //return super.calculateNetSalary();
    }

    @Override
    public String toString() {
        return "full time employee";
    }
}
