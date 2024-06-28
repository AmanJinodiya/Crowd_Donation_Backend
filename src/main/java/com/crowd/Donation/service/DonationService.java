package com.crowd.Donation.service;

import com.crowd.Donation.models.Campaign;
import com.crowd.Donation.models.Donation;
import com.crowd.Donation.models.User;
import com.crowd.Donation.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

//    create
    public Donation createDonation(Donation donation){
        return this.donationRepository.save(donation);
    }



//    get
    public Donation getDonationById(long id){
        return this.donationRepository.findById(id).get();
    }

    public List<Donation> getAllDonation(){
        return this.donationRepository.findAll();
    }

    public ArrayList<Integer> getAllDonationByMonth(){
        List<Donation> li = this.donationRepository.findAll();
        ArrayList<Integer> arr = new ArrayList<>(Collections.nCopies(12, 0));

        for (Donation x : li) {
            int month = x.getMn();
            int amount = x.getAmount();

            arr.set(month, arr.get(month) + amount); // Adjust month index to start from 0
        }

        return arr;




    }

    public List<Donation> getDonationFromUser(User user){
        return this.donationRepository.findByUser(user);   }

    public List<Donation> getDonationByCampaign(Campaign campaign){
        return this.donationRepository.findByCampaign(campaign);   }

//    update
    public Donation updateDonation(){return null;}

//    delete
    public void deleteDonation(long id){
        this.donationRepository.deleteById(id);
    }

}
