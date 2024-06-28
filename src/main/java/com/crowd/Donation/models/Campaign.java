package com.crowd.Donation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.java.Log;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignId;
    @Column(length = 10000)
    private String tittle;
    private String description;
    private Long goal_amount;
    private Long collected_amount;
    private String start_date;
    private String end_date;
    private String tag;
    private Boolean active_status = false;
    private Boolean admin_status = false;
    private String image;
    @Column(length = 10000)
    private String story;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_UserId")
    private User user;

    @OneToMany(mappedBy = "campaign",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Donation> donations;


}
