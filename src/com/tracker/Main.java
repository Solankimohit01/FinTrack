package com.tracker;

import com.tracker.model.Transaction;
import com.tracker.service.FinanceService;
import com.tracker.util.InputUtil;

import java.time.LocalDate;
import java.util.List;

public class Main {
    private static final FinanceService service = new FinanceService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n====== Personal Finance Tracker ======");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View All Transactions");
            System.out.println("4. View Balance");
            System.out.println("5. View Category-wise Total");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String option = InputUtil.getString("");

            switch (option) {
                case "1" -> addTransaction("Income");
                case "2" -> addTransaction("Expense");
                case "3" -> viewAllTransactions();
                case "4" -> viewBalance();
                case "5" -> viewCategoryTotal();
                case "0" -> {
                    System.out.println("👋 Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }

    private static void addTransaction(String type) {
        String category = InputUtil.getString("Enter category: ");
        double amount = InputUtil.getDouble("Enter amount (₹): ");
        String note = InputUtil.getString("Enter note (optional): ");
        Transaction t = new Transaction(type, category, amount, LocalDate.now(), note);
        service.addTransaction(t);
        System.out.println("✅ " + type + " added!");
    }

    private static void viewAllTransactions() {
        List<Transaction> all = service.getAllTransactions();
        if (all.isEmpty()) {
            System.out.println("📭 No transactions found.");
        } else {
            all.forEach(System.out::println);
        }
    }

    private static void viewBalance() {
        System.out.println("💰 Current Balance: ₹" + service.getCurrentBalance());
    }

    private static void viewCategoryTotal() {
        String type = InputUtil.getString("Type (Income/Expense): ");
        String category = InputUtil.getString("Enter category: ");
        double total = service.getCategoryTotal(category, type);
        System.out.println("📊 Total " + type + " in category '" + category + "': ₹" + total);
    }
}
