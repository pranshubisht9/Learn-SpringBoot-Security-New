package com.app.service;

import com.app.model.Customer;
import com.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerUserDetailsService implements UserDetailsService {
        @Autowired
        private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> opt = customerRepository.findByEmail(username);

        if(opt.isPresent()){
            Customer customer = opt.get();

            //Empty authorities
            List<GrantedAuthority> authorities = new ArrayList<>();
            //authorities.add(new SimpleGrantedAuthority(customer.getRole()));
            return new User(customer.getEmail(), customer.getPassword(), authorities);

        }else{
            throw new BadCredentialsException("UserDetails not found with this username: "+ username);
        }
    }
}
