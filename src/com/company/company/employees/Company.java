package com.company.company.employees;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Company {
    private ArrayList<Employee> workers;
    private ArrayList<Customer> customers;
    private ArrayList<Emailable> allPeople = new ArrayList<>();

    public double sumOfNettoSalaries() {
        double sum = 0;
        for (Employee employee : workers) {
            sum += employee.calculateNetSalary();
        }
        return sum;
    }

    public double averageOfNettoSalaries() {
        return sumOfNettoSalaries() / workers.size();
    }

    public double sumOfBruttoSalaries() {
        double sum = 0;
        for (Employee employee : workers) {
            sum += employee.getGrossSalary();
        }
        return sum;
    }

    public double averageOfBruttoSalaries() {
        return sumOfBruttoSalaries() / workers.size();
    }

    public void readWorkers(String file) {
        workers = new ArrayList<>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream((new File(file))));
            workers = (ArrayList<Employee>) is.readObject();
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("workers input file not found, will be created after the first run!");
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (workers.size() > 0) {
            for (Employee worker : workers) {
                allPeople.add(worker);
            }
        }
    }

    public void readCustomers(String file) {
        customers = new ArrayList<>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream((new File(file))));
            customers = (ArrayList<Customer>) is.readObject();
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("customers input file not found, will be created after the first run!");
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (customers.size() > 0) {
            for (Customer customer : customers) {
                allPeople.add(customer);
            }
        }
    }

    public boolean writeWorkers(String file) {
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

    public boolean writeCustomers(String file) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(file)));
            os.writeObject(customers);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addCustomer(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail().compareToIgnoreCase(email) == 0) {
                System.out.println("Customer already in the database, skipped.");
                return false;
            }
        }
        customers.add(new Customer(email));
        return true;
    }

    public boolean addEmployee(double grossSalary, String email, String type) {
        for (Employee worker : workers) {
            if (worker.getEmail().compareToIgnoreCase(email) == 0) {
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
        Locale.setDefault(new Locale("en", "US"));
        Company company1 = new Company();
        company1.readWorkers("company1_workers.bin");
        company1.readCustomers("company1_customers.bin");
        /*company1.addEmployee(1200., "stefan@gmail.com", "student");
        company1.addEmployee(1200., "jozef@gmail.com", "student");
        company1.addEmployee(1200., "franek@gmail.com", "student");
        company1.addEmployee(5000., "francjos@interia.pl", "full");
        company1.addEmployee(3000, "jan@op.pl", "temporary");
        company1.addCustomer("mateusz@gmail.com");
        company1.addCustomer("krzycho@gmail.com");*/
        int i = 1;
        for (Employee worker : company1.workers) {
            System.out.printf("Worker %d; brutto salary: %.2f PLN, netto salary: %.2f PLN, email: %s, status: %s%n", i, worker.getGrossSalary(), worker.calculateNetSalary(), worker.getEmail(), worker.toString());
            i++;
        }
        System.out.println();
        System.out.printf("Average brutto salaries in company1: %.2f PLN%n", company1.averageOfBruttoSalaries());
        System.out.printf("Average netto salaries in company1: %.2f PLN%n", company1.averageOfNettoSalaries());
        System.out.println();
        i = 1;
        for (Customer customer : company1.customers) {
            System.out.printf("Customer %d; email: %s%n", i, customer.getEmail());
            i++;
        }
        System.out.println();
        System.out.println("All my people (workers & customers):");
        //System.out.println(company1.allPeople.size());
        i = 1;
        if (company1.allPeople.size() > 0) {
            for (Emailable person : company1.allPeople) {
                System.out.printf("person %d, email: %s%n", i, person.getEmail());
                i++;
            }
        }
        company1.writeWorkers("company1_workers.bin");
        company1.writeCustomers("company1_customers.bin");
    }
}
