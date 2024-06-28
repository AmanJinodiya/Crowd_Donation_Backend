package com.crowd.Donation.service;

import com.crowd.Donation.models.User;
import com.crowd.Donation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(username);
        if (user == null){
            System.out.println("No user Found");
            throw new UsernameNotFoundException("No user found!!");
        }
        return user;
    }
}