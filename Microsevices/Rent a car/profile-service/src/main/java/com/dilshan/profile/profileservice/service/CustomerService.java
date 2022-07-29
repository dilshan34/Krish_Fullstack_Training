package com.dilshan.profile.profileservice.service;

import com.dilshan.model.Customer;

import java.util.List;

public interface CustomerService {

     Customer save(Customer customer);

     Customer fetchById(int profileId);

     List<Customer> fetchAllProfiles();
}
