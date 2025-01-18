package com.jen.service;

import com.jen.dao.ItemDAO;
import com.jen.dao.ItemIMP;
import com.jen.models.item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ItemService {

    private final ItemDAO itemDAO;

    public ItemService() {
        this.itemDAO = new ItemIMP();
    }

    public void addNewItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Add a New Item ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        String priceStr = scanner.nextLine();

        BigDecimal price;
        try {
            price = new BigDecimal(priceStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format, item not added.");
            return;
        }

        item newItem = new item();
        newItem.setName(name);
        newItem.setPrice(price);

        boolean success = itemDAO.addItem(newItem);
        System.out.println(success ? "Item added successfully!" : "Failed to add item.");
    }

    public void removeItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Remove an Item ---");
        System.out.print("Enter Item ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean removed = itemDAO.removeItemById(id);
        System.out.println(removed ? "Item removed." : "No item found with that ID.");
    }

    public void getAllItems() {
        System.out.println("\n--- List All Items ---");
        List<item> items = itemDAO.getAllItems();
        if (items.isEmpty()) {
            System.out.println("No items in the database.");
        } else {
            for (item i : items) {
                System.out.println(i);
            }
        }
    }
}
