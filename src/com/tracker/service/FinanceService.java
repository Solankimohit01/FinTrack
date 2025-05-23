package com.tracker.service;

import com.tracker.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class FinanceService {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    public double getCurrentBalance() {
        double income = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Income"))
                .mapToDouble(Transaction::getAmount).sum();
        double expense = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Expense"))
                .mapToDouble(Transaction::getAmount).sum();
        return income - expense;
    }

    public double getCategoryTotal(String category, String type) {
        return transactions.stream()
                .filter(t -> t.getCategory().equalsIgnoreCase(category)
                        && t.getType().equalsIgnoreCase(type))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}
