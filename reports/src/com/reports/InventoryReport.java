package com.reports;

import com.inventory.RunbookInventory;

public class InventoryReport {
    public void generateReport() {
        RunbookInventory inventory = new RunbookInventory();
        inventory.listRunbooks().forEach(runbook -> System.out.println("Report - Book: " + runbook.title()));
    }
}
