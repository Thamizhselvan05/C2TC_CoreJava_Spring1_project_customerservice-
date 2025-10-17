package com.tnsif.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.customerservice.entity.Customer;
import com.tnsif.customerservice.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    // Get all customers
    public List<Customer> listAll() {
        return repo.findAll();
    }

    // Save new customer
    public void save(Customer c) {
        repo.save(c);
    }

    // Get customer by ID
    public Customer get(Integer id) {
        return repo.findById(id).get();
    }

    // Delete customer
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    // Update customer
    public void update(Customer c) {
        repo.save(c);
    }
}
