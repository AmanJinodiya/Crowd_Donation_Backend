package com.crowd.Donation.service;

import com.crowd.Donation.models.Transaction;
import com.crowd.Donation.repository.TransactionRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepostiory transactionRepostiory;

//    crete
    public Transaction createTransaction(Transaction transaction){
        return this.transactionRepostiory.save(transaction);
    }

//    get
    public Transaction getTransactionById(long id){
        return this.transactionRepostiory.findById(id).get();
    }
    public List<Transaction> getAllTransaction(){
        return this.transactionRepostiory.findAll();
    }

//    delete
    public void deleteTransaction(long id){
        this.transactionRepostiory.deleteById(id);
    }


}
