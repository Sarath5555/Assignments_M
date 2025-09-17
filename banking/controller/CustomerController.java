// CustomerController.java
package com.example.banking.controller;

import com.example.banking.entity.Address;
import com.example.banking.entity.Customer;
import com.example.banking.exception.CustomerNotFoundException;
import com.example.banking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustById(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.getCustById(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomerById(id, customer);
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.deleteCustomer(id);
    }

    @PatchMapping("/{id}/name")
    public Customer updateCustomerName(@PathVariable Long id, @RequestBody String name) throws CustomerNotFoundException {
        return customerService.updateCustomerName(id, name);
    }

    @PatchMapping("/{id}/address")
    public Customer updateCustomerAddr(@PathVariable Long id, @RequestBody Address addr) {
        return customerService.updateCustomerAddr(id, addr);
    }

    @GetMapping("/name/{name}")
    public List<Customer> getByName(@PathVariable String name) {
        return customerService.getCustByName(name);
    }

    @GetMapping("/dob/{dob}")
    public List<Customer> getByDob(@PathVariable LocalDate dob) {
        return customerService.getCustByDob(dob);
    }

    @PatchMapping("/{id}/dob")
    public Customer updateDob(@PathVariable Long id, @RequestBody LocalDate dob) {
        return customerService.updateCustDob(id, dob);
    }
}
