package com.tnsif.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.customerservice.entity.Customer;
import com.tnsif.customerservice.service.CustomerService;

import jakarta.persistence.NoResultException;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/customerservices")
    public List<Customer> list() {
        return service.listAll();
    }

    @PostMapping("/customerservices")
    public void add(@RequestBody Customer c) {
        service.save(c);
    }

    @GetMapping("/customerservices/{id}")
    public ResponseEntity<Customer> get(@PathVariable Integer id) {
        try {
            Customer c = service.get(id);
            return new ResponseEntity<Customer>(c, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/customerservices/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PutMapping("/customerservices/{id}")
    public ResponseEntity<Customer> update(@PathVariable Integer id, @RequestBody Customer update_c) {
        try {
            Customer exist = service.get(id);
            exist.setCustomerName(update_c.getCustomerName());
            exist.setEmail(update_c.getEmail());
            exist.setPhone(update_c.getPhone());
            exist.setAddress(update_c.getAddress());
            service.update(exist);
            return new ResponseEntity<Customer>(exist, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }
}
