package com.jen;

import com.jen.service.CustomerService;
import com.jen.service.ItemService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        ItemService itemService = new ItemService();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add New Customer");
            System.out.println("2. Remove Customer");
            System.out.println("3. Get Customer By ID");
            System.out.println("4. List All Customers");
            System.out.println("5. Add New Item");
            System.out.println("6. Remove Item");
            System.out.println("7. List All Items");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");


            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
                continue;
            }


            if (choice == 1) {

                customerService.addNewCustomer();
            } else if (choice == 2) {

                customerService.removeCustomer();
            } else if (choice == 3) {

                customerService.getCustomerById();
            } else if (choice == 4) {

                customerService.getAllCustomers();
            } else if (choice == 5) {

                itemService.addNewItem();
            } else if (choice == 6) {

                itemService.removeItem();

            } else if (choice == 7) {

                itemService.getAllItems();
            } else if (choice == 8) {

                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting program. Goodbye!");
        scanner.close();
    }
}
