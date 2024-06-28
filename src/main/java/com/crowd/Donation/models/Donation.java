package com.crowd.Donation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Donation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long donationId;
    private String name;
    private int amount;
    private String date;

    private int mn;


    @ManyToOne()
    @JoinColumn(name = "fk_userId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_campaignId")
    private Campaign campaign;
}
