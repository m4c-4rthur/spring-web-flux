package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AccountRepository;
import com.example.demo.model.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
public class AccountController {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
 
    @Autowired
    private AccountRepository repository;
 
    @GetMapping("/customer/{customer}")
    public Flux findByCustomer(@PathVariable("customer") String customerId) {
        LOGGER.info("findByCustomer: customerId={}", customerId);
        return repository.findByCustomerId(customerId);
    }
 
    @GetMapping
    public Flux findAll() {
        LOGGER.info("findAll");
        return repository.findAll();
    }
 
    @GetMapping("/{id}")
    public Mono findById(@PathVariable("id") String id) {
        LOGGER.info("findById: id={}", id);
        return repository.findById(id);
    }
 
    @PostMapping
    public Mono create(@RequestBody Account account) {
        LOGGER.info("create: {}", account);
        return repository.save(account);
    }
 
}
