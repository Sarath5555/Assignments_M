package com.example.springdemo.service;

import com.example.springdemo.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService{
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    Customer updateCustomer(Long id, Customer updatedCustomer);
    void deleteCustomer(Long id);
}
