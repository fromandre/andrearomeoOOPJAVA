package it.eng.corso.budget_service.repository;

import it.eng.corso.budget_service.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
