package com.inventory;

import com.bookapi.Runbook;
import java.util.ArrayList;
import java.util.List;

public class RunbookInventory {
    public List<Runbook> runbooks;

    public RunbookInventory() {
        this.runbooks = new ArrayList<>();
        runbooks.add(new Runbook("OCA Study Guide"));
        runbooks.add(new Runbook("OCP Study Guide"));
    }

    public List<Runbook> listRunbooks() { return runbooks; }
}
