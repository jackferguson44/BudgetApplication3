package com.example.budgetapplication3;

public class Budget {
    private String budgetItem;
    private String budgetCost;

    public Budget(String budgetItem, String budgetCost) {
        this.budgetItem = budgetItem;
        this.budgetCost = budgetCost;
    }

    public String getBudgetItem() {
        return budgetItem;
    }

    public void setBudgetItem(String budgetItem) {
        this.budgetItem = budgetItem;
    }

    public String getBudgetCost() {
        return budgetCost;
    }

    public void setBudgetCost(String budgetCost) {
        this.budgetCost = budgetCost;
    }
}
