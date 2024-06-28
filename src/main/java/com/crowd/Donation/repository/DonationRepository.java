package com.crowd.Donation.repository;

import com.crowd.Donation.models.Campaign;
import com.crowd.Donation.models.Donation;
import com.crowd.Donation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {

    List<Donation> findByUser(User user);

    List<Donation> findByCampaign(Campaign campaign);



}
