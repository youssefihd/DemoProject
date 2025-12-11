package repo;

import entities.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public void add(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction is null");
        }
        transactions.add(transaction);
    }
    public List<Transaction> getAll() {
        return Collections.unmodifiableList(transactions);
    }
}
