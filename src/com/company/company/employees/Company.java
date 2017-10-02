package com.company.company.employees;

import java.io.*;
import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> workers;

    public ArrayList<Employee> readList(String file) {
        workers = new ArrayList<>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream((new File(file))));
            workers = (ArrayList<Employee>) is.readObject();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return workers;
    }

    public boolean writeList(String file) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(file)));
            os.writeObject(workers);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addEmployee(double grossSalary, String email, String type) {
        for (Employee worker : workers) {
            if (worker.getEmail() == email) {
                System.out.println("Worker already in the database, skipped.");
                return false;
            }
        }
        if (type.compareToIgnoreCase("student") == 0) {
            workers.add(new Student(grossSalary, email));
            return true;
        } else if (type.compareToIgnoreCase("full") == 0) {
            workers.add(new FullTimeEmployee(grossSalary, email));
            return true;
        } else if (type.compareToIgnoreCase("temporary") == 0) {
            workers.add(new TemporaryEmployee(grossSalary, email));
            return true;
        } else {
            System.out.println("Operation aborted. Choose between: student, full, temporary.");
            return false;
        }
    }

    public static void main(String[] args) {
        Company company1 = new Company();
        company1.readList("company1.bin");
        company1.addEmployee(1200., "stefan@gmail.com", "student");
        //company1.addEmployee(1200., "jozef@gmail.com", "student");
        //company1.addEmployee(1200., "franek@gmail.com", "student");
        company1.writeList("company1.bin");
    }
}
