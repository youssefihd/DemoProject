package service;

import entities.Transaction;
import exception.InvalidAmountException;
import repo.TransactionRepository;

import java.time.Clock;
import java.time.LocalDate;


public class Account implements AccountService {
    private final TransactionRepository repository;
    private final StatementPrinter printer;
    public Account() {
        this(new TransactionRepository(), new StatementPrinter());
    }

    public Account(TransactionRepository repository, StatementPrinter printer) {
        if (repository == null) {
            throw new IllegalArgumentException("Repository cannot be null");
        }
        if (printer == null) {
            throw new IllegalArgumentException("Printer cannot be null");
        }
        this.repository = repository;
        this.printer = printer;
    }

    @Override
    public void deposit(int amount) {
        validateAmount(amount);

        LocalDate date = LocalDate.now();
        Transaction transaction = new Transaction(date, amount);
        repository.add(transaction);
    }


    @Override
    public void withdraw(int amount) {
        validateAmount(amount);

        LocalDate date = LocalDate.now();
        Transaction transaction = new Transaction(date, -amount);
        repository.add(transaction);
    }


    @Override
    public void printStatement() {
        printer.print(repository.getAll());
    }

    private void validateAmount(int amount){
        if (amount <= 0) {
            throw new InvalidAmountException("The amount should be positive, got: " + amount);
        }
    }

}