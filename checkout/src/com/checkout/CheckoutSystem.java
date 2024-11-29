package com.checkout;

import com.bookapi.Runbook;
import com.inventory.RunbookInventory;
import com.notificationservice.NotificationService;

import java.util.ServiceLoader;

public class CheckoutSystem {
    public void checkoutRunbook(String title) {
        RunbookInventory inventory = new RunbookInventory();
        Runbook runbook = inventory.listRunbooks().stream().filter(b -> b.title().equals(title)).findFirst().orElse(null);
        if (runbook != null) {
            System.out.println("Checked out: " + runbook);
            NotificationService notificationService = ServiceLoader.load(NotificationService.class)
                    .stream()
                    .map(ServiceLoader.Provider::get)
                    .filter(service -> service.getName().equals("Email"))
                    .findFirst()
                    .orElseThrow();
            notificationService.sendNotification("You've checked out: " + runbook.title());
        } else {
            System.out.println("Book not available: " + title);
        }
    }
}
