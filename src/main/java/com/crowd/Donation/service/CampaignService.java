package com.crowd.Donation.service;


import com.crowd.Donation.models.Campaign;
import com.crowd.Donation.models.Donation;
import com.crowd.Donation.models.User;
import com.crowd.Donation.repository.CampaignRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepostiory campaignRepostiory;

//    create
    public Campaign createCampaign(Campaign campaign){
        return this.campaignRepostiory.save(campaign);
    }

//    get

    public Campaign getCampaignById(Long campaignId){
        return this.campaignRepostiory.findById(campaignId).get();
    }

    public List<Campaign> getAllCampaign(){
        return  this.campaignRepostiory.findAll();
    }

    public int getAllActiveCampaign(){
        List<Campaign> li = this.campaignRepostiory.findAll();

        int nu = 0;

        for (Campaign x : li) {
            if(x.getAdmin_status() == true) nu++;
            // Adjust month index to start from 0
        }

        return nu;

    }

//    update

    public Campaign updateCampaign(Campaign updatedCampaign){
        return this.campaignRepostiory.save(updatedCampaign);
    }

    public List<Campaign> getCampaignByUser(User user){return  this.campaignRepostiory.findByUser(user);}



//    detete
    public void deleteCampaign(Long campaignId){
    this.campaignRepostiory.deleteById(campaignId);
}



}
