package com.company;

import com.company.company.employees.Employee;

import java.io.*;
import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees = new ArrayList<>();

    public boolean addEmployee(double grossSalary, String email, String type) {
        //employees.
        return true;
    }

    public static ArrayList<Employee> readEmployees(String file) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File(file)));
            list = (ArrayList<Employee>) is.readObject();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean writeEmployees(String file, ArrayList<Employee> list) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(file)));
            os.writeObject(list);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        Company company1 = new Company();
        company1.employees = readEmployees("employees1.bin");
        //company1.addEmployee(1200, "stefan@gmail.com");

    }
}
