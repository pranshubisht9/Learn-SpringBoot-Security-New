package com.app.service;

import com.app.exception.CustomerException;
import com.app.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer registerCustomer(Customer customer);
    public Customer getCustomerDetailsByEmail(String email) throws CustomerException;
    public List<Customer> getAllCustomerDetails() throws CustomerException;
}
