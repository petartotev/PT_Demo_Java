package com.checkout;

import com.bookapi.Book;
import com.inventory.BookInventory;
import com.notificationservice.NotificationService;

import java.util.ServiceLoader;

public class CheckoutSystem {
    public void checkoutBook(String title) {
        BookInventory inventory = new BookInventory();
        Book book = inventory.listBooks().stream().filter(b -> b.title().equals(title)).findFirst().orElse(null);
        if (book != null) {
            System.out.println("Checked out: " + book);
            NotificationService notificationService = ServiceLoader.load(NotificationService.class)
                    .stream()
                    .map(ServiceLoader.Provider::get)
                    .filter(service -> service.getName().equals("Email"))
                    .findFirst()
                    .orElseThrow();
            notificationService.sendNotification("You've checked out: " + book.title());
        } else {
            System.out.println("Book not available: " + title);
        }
    }
}
