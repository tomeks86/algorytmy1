package com.company.company.employees;

public class Customer implements Emailable {
    private String email;

    public Customer(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
