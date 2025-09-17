// CustomerService.java
package com.example.banking.service;

import com.example.banking.entity.Address;
import com.example.banking.entity.Customer;
import com.example.banking.exception.CustomerNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustById(Long custId) throws CustomerNotFoundException;
    Customer updateCustomerById(Long custId, Customer cust);
    Customer deleteCustomer(Long custId) throws CustomerNotFoundException;
    Customer updateCustomerName(Long custId, String newName) throws CustomerNotFoundException;
    Customer updateCustomerAddr(Long custId, Address addr);
    List<Customer> getCustByName(String custName);
    List<Customer> getCustByDob(LocalDate dob);
    Customer updateCustDob(Long custId, LocalDate date);
}
