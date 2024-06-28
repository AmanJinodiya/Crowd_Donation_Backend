package com.crowd.Donation.controller;

import com.crowd.Donation.models.Transaction;
import com.crowd.Donation.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@CrossOrigin("*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/")
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction){
        return ResponseEntity.ok(this.transactionService.createTransaction(transaction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable("id") long id){
        return ResponseEntity.ok(this.transactionService.getTransactionById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllTransaction(){
        return ResponseEntity.ok(this.transactionService.getAllTransaction());
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable("id") long id){
        this.transactionService.deleteTransaction(id);
    }
}
