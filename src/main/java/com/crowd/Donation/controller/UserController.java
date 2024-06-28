package com.crowd.Donation.controller;

import com.crowd.Donation.models.User;
import com.crowd.Donation.service.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController()
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    //    creating user
    @PostMapping("/")
    public ResponseEntity<?>  createUser(@RequestBody User user){

        try {
            return ResponseEntity.ok(this.userService.createUser(user));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @GetMapping("/email/{email}")
//    public ResponseEntity<?>  getUserByEmail(@PathVariable("email") String email){
//        return ResponseEntity.ok(this.userService.getUserByEmail(email));
//
//    }

    @GetMapping("/{username}")
    public ResponseEntity<?>  getUserByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(this.userService.getUserByUsername(username));

    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
//        return  ResponseEntity.ok(this.userService.getUserById(id));
//    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(this.userService.getAllUser());
    }

    @PutMapping("/")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try {
            return ResponseEntity.ok(this.userService.updateUser(user));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }


//    payment
    @PostMapping("/createOrder")
    public ResponseEntity<?>  createOrder(@RequestBody Map<String,Object> data) throws RazorpayException {
        System.out.println(data);

        int amt = Integer.parseInt(data.get("amount").toString());
        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_LPN0q02qY6t5ej", "SBd1IARxkpe8pzoYaB7fGuwl");
        JSONObject options = new JSONObject();
        options.put("amount", amt*100);
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        Order order = razorpayClient.Orders.create(options);

        System.out.println(order);

        return ResponseEntity.ok(order.toString());

    }


}
