package it.eng.corso.budget_service.service;

import it.eng.corso.budget_service.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    List<Transaction> getAllTransactions();

    void deleteTransaction(Long id);

    BigDecimal calculateTotalIncome();

    BigDecimal calculateTotalExpenses();

    BigDecimal calculateBalance();
}
