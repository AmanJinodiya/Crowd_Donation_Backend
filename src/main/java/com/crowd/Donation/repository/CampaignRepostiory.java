package com.crowd.Donation.repository;

import com.crowd.Donation.models.Campaign;
import com.crowd.Donation.models.Donation;
import com.crowd.Donation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepostiory extends JpaRepository<Campaign,Long> {

    List<Campaign> findByUser(User user);
}
