package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springdemo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{}
