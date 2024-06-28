package com.crowd.Donation.repository;
import com.crowd.Donation.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepostiory extends JpaRepository<Transaction,Long> {
}
