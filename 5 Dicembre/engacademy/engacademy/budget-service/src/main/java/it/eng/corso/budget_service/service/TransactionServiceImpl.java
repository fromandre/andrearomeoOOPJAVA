package it.eng.corso.budget_service.service;

import it.eng.corso.budget_service.model.Transaction;
import it.eng.corso.budget_service.model.TransactionType;
import it.eng.corso.budget_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;


public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository repository;

    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }

    public BigDecimal calculateTotalIncome() {
        return repository.findAll().stream()
                .filter(t -> t.getType() == TransactionType.INCOME)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateTotalExpenses() {
        return repository.findAll().stream()
                .filter(t -> t.getType() == TransactionType.EXPENSE)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateBalance() {
        return calculateTotalIncome().subtract(calculateTotalExpenses());
    }
}
