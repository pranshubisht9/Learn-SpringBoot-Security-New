package com.app.controller;

import com.app.model.Customer;
import com.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/hello")
    public String testHandler(){
        return "Welcome to Spring Security";
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        Customer registeredCustomer = customerService.registerCustomer(customer);

        return new ResponseEntity<>(registeredCustomer, HttpStatus.ACCEPTED);
    }
}
