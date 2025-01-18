package com.jen.service;

import com.jen.dao.CustomerDAO;
import com.jen.dao.CustomerIMP;
import com.jen.models.customer;

import java.util.List;
import java.util.Scanner;

public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerIMP();
    }

    public void addNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Add New Customer ---");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("First name: ");
        String fname = scanner.nextLine();
        System.out.print("Last name: ");
        String lname = scanner.nextLine();

        customer c = new customer();
        c.setEmail(email);
        c.setFname(fname);
        c.setLname(lname);

        boolean added = customerDAO.addCustomer(c);
        System.out.println(added ? "Customer added successfully!" : "Failed to add customer.");
    }

    public void removeCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Remove Customer ---");
        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean removed = customerDAO.removeCustomerById(id);
        System.out.println(removed ? "Customer removed." : "No customer found with ID " + id);
    }

    public void getCustomerById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Get Customer By ID ---");
        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        customer c = customerDAO.getCustomerById(id);
        if (c != null) {
            System.out.println("Customer: " + c);
        } else {
            System.out.println("No customer found with ID " + id);
        }
    }

    public void getAllCustomers() {
        System.out.println("\n--- List All Customers ---");
        List<customer> all = customerDAO.getAllCustomers();
        if (all.isEmpty()) {
            System.out.println("No customers in the database.");
        } else {
            for (customer c : all) {
                System.out.println(c);
            }
        }
    }
}
