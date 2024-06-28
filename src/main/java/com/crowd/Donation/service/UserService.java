package com.crowd.Donation.service;

import com.crowd.Donation.models.User;
import com.crowd.Donation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
//    get
//    public User getUserByEmail(String email){
//        User temp = this.userRepository.findByEmail(email);
//        System.out.println(temp.getFirst_name());
//        return  temp;
//    }

    public User getUserById(Long id){
        return this.userRepository.findById(id).get();
    }

    public User getUserByUsername(String username){
        return this.userRepository.findByUsername(username);
    }

    public List<User> getAllUser(){
        return  this.userRepository.findAll();
    }

//    create
    public User createUser(User user) throws Exception {
        User local = this.userRepository.findByEmail(user.getEmail());
        if(local != null){
            System.out.println("User already exist");
            throw new Exception("User Already Exists");
        }
        else{
            local = this.userRepository.save(user);
        }
        return local;
    }

//    update
    public User updateUser(User updatedUser) throws Exception {
    // Check if the user exists in the database
    User existingUser = userRepository.findById(updatedUser.getUserId()).orElse(null);
    if (existingUser == null) {
        throw new Exception("User not found");
    }

    return userRepository.save(updatedUser);
}
//    delete
    public void deleteUser(Long userId){
        this.userRepository.deleteById(userId);
    }


}
