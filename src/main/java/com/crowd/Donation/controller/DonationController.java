package com.crowd.Donation.controller;

import com.crowd.Donation.models.Campaign;
import com.crowd.Donation.models.Donation;
import com.crowd.Donation.models.User;
import com.crowd.Donation.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/donation")
@CrossOrigin("*")
public class DonationController {

    @Autowired
    private DonationService donationService;


    @PostMapping("/")
    public ResponseEntity<?> createDonation(@RequestBody Donation donation){
        LocalDate currentDate = LocalDate.now();

        // Get the current month as an int value (1 to 12)
        int currentMonth = currentDate.getMonthValue() -1;

        donation.setMn(currentMonth);
        return ResponseEntity.ok(this.donationService.createDonation(donation));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDonationById(@PathVariable("id") long id){
        return ResponseEntity.ok(this.donationService.getDonationById(id));
    }

    @GetMapping("/month/")
    public ResponseEntity<?> getDonationByMonth(){
        return ResponseEntity.ok(this.donationService.getAllDonationByMonth());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getDonationByUser(@PathVariable("id") long id){
        User user = new User();
        user.setUserId(id);
        return ResponseEntity.ok(this.donationService.getDonationFromUser(user));
    }

    @GetMapping("/campaign/{id}")
    public ResponseEntity<?> getDonationByCampaign(@PathVariable("id") long id){
        Campaign campaign = new Campaign();
        campaign.setCampaignId(id);
        return ResponseEntity.ok(this.donationService.getDonationByCampaign(campaign));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllDonation(){
        return ResponseEntity.ok(this.donationService.getAllDonation());
    }

    @DeleteMapping("/{id}")
    public void deleteDonation(@PathVariable("id") long id){
         this.donationService.deleteDonation(id);
    }



}
