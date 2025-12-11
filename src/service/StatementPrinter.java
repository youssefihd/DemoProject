package service;

import entities.Transaction;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatementPrinter {

    private static final String HEADER = " Date      || Amount || Balance";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
private static final String EMPTY = "No action has been made yet";
    public void print(List<Transaction> transactions) {
        System.out.println(HEADER);

        if (transactions.isEmpty()) {
            System.out.println(EMPTY);
        }

        List<String> lines = new ArrayList<>();
        int balance = 0;

        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
            String line = formatLine(transaction, balance);
            lines.add(line);
        }

        Collections.reverse(lines);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private String formatLine(Transaction transaction, int balance) {
        String date = transaction.getDate().format(DATE_FORMAT);
        int amount = transaction.getAmount();

        return String.format("%s || %d   || %d", date, amount, balance);
    }
}
