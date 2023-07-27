package com.app.controller;

import com.app.model.Customer;
import com.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/signIn")
    public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
        System.out.println(auth); //this Authentication object having Principle object details
        Customer customer = customerRepository.findByEmail(auth.getName()).orElseThrow(()-> new BadCredentialsException("wrong credentials"));
                return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
    }
}
