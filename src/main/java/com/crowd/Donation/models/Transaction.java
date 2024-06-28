package com.crowd.Donation.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private String method;
    private Boolean status;
    private String timestamp;
    private String date;

}
