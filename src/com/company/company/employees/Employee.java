package com.company.company.employees;

public abstract class Employee implements Emailable {
    double grossSalary;
    private double taxRate;
    private String email;

    @Override
    public String getEmail() {
        return email;
    }

    public Employee(double grossSalary, double taxRate, String email) {
        this.grossSalary = grossSalary;
        this.taxRate = taxRate;
        this.email = email;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double calculateNetSalary() {
        return getGrossSalary() / (1. + getTaxRate()/100.);
    }
}
