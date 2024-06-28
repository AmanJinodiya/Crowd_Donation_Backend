package com.crowd.Donation.controller;

import com.crowd.Donation.models.Campaign;
import com.crowd.Donation.models.User;
import com.crowd.Donation.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaign")
@CrossOrigin("*")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

//    create
    @PostMapping("/")
    public ResponseEntity<?> createCampaign(@RequestBody Campaign campaign){
        return ResponseEntity.ok(this.campaignService.createCampaign(campaign));
    }

//    get
    @GetMapping("/{id}")
    public ResponseEntity<?> getCampaign(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.campaignService.getCampaignById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getCampaignByUser(@PathVariable("id") Long id){
        User user = new User();
        user.setUserId(id);
        return ResponseEntity.ok(this.campaignService.getCampaignByUser(user));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCompaign(){
        return ResponseEntity.ok(this.campaignService.getAllCampaign());
    }

    @GetMapping("/active/")
    public ResponseEntity<?> getAllActiveCompaign(){
        return ResponseEntity.ok(this.campaignService.getAllActiveCampaign());
    }

//    update

    @PutMapping("/")
    public ResponseEntity<?> updateCampaign(@RequestBody Campaign campaign){
        return ResponseEntity.ok(this.campaignService.updateCampaign(campaign));
    }

//    delete
    @DeleteMapping("/{id}")
    public void deleteCampaign(@PathVariable("id") Long id){
        this.campaignService.deleteCampaign(id);
    }
}
