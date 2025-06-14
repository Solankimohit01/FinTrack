package com.tracker.model;

import java.time.LocalDate;

public class Transaction {
    private String type; // "Income" or "Expense"
    private String category;
    private double amount;
    private LocalDate date;
    private String note;

    public Transaction(String type, String category, double amount, LocalDate date, String note) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.note = note;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "[" + date + "] ₹" + amount + " (" + type + " - " + category + ") - " + note;
    }
}
