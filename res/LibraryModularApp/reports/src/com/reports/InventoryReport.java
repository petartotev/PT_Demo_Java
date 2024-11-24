package com.reports;

import com.inventory.BookInventory;

public class InventoryReport {
    public void generateReport() {
        BookInventory inventory = new BookInventory();
        inventory.listBooks().forEach(book -> System.out.println("Report - Book: " + book.title()));
    }
}
