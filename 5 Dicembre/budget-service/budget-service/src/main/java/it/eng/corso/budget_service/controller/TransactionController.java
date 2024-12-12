package it.eng.corso.budget_service.controller;

import it.eng.corso.budget_service.model.Transaction;
import it.eng.corso.budget_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    /*public TransactionController(TransactionService service) {
        this.service = service;
    }*/

    @PostMapping
    public ResponseEntity<Transaction> createTransaction( @RequestBody Transaction transaction) {
        return ResponseEntity.ok(service.saveTransaction(transaction));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(service.getAllTransactions());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        service.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/summary")
    public ResponseEntity<Object> getSummary() {

        HashMap<String, Object> body = new HashMap<>();
        body.put("totalIncome",service.calculateTotalIncome() );
        body.put("totalExpenses",service.calculateTotalExpenses() );
        body.put("balance",service.calculateBalance() );
        return ResponseEntity.ok(body);
    }
}
