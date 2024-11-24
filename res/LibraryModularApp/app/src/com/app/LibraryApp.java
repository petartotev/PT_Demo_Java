package com.app;

import com.checkout.CheckoutSystem;
import com.reports.InventoryReport;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the LibraryModularApp!");

        // Generate report
        System.out.println("Available books:");
        var inventoryReport = new InventoryReport();
        inventoryReport.generateReport();

        // Taking input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the book you want to checkout:");
        String bookName = scanner.nextLine();

        CheckoutSystem checkoutSystem = new CheckoutSystem();
        checkoutSystem.checkoutBook(bookName);
    }
}
