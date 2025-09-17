// CustomerServiceImpl.java
package com.example.banking.serviceImpl;

import com.example.banking.entity.Address;
import com.example.banking.entity.Customer;
import com.example.banking.exception.CustomerNotFoundException;
import com.example.banking.repository.AddressRepository;
import com.example.banking.repository.CustomerRepository;
import com.example.banking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustById(Long custId) throws CustomerNotFoundException {
        return customerRepo.findById(custId).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }

    @Override
    public Customer updateCustomerById(Long custId, Customer cust) {
        cust.setCustomerId(custId);
        return customerRepo.save(cust);
    }

    @Override
    public Customer deleteCustomer(Long custId) throws CustomerNotFoundException {
        Customer c = customerRepo.findById(custId).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        customerRepo.delete(c);
        return c;
    }

    @Override
    public Customer updateCustomerName(Long custId, String newName) throws CustomerNotFoundException {
        Customer c = customerRepo.findById(custId).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        c.setFullName(newName);
        return customerRepo.save(c);
    }

    @Override
    public Customer updateCustomerAddr(Long custId, Address addr) {
        Customer c = customerRepo.findById(custId).get();
        addr.setCustomer(c);
        addressRepo.save(addr);
        return c;
    }

    @Override
    public List<Customer> getCustByName(String custName) {
        return customerRepo.findByFullName(custName);
    }

    @Override
    public List<Customer> getCustByDob(LocalDate dob) {
        return customerRepo.findByDob(dob);
    }

    @Override
    public Customer updateCustDob(Long custId, LocalDate date) {
        Customer c = customerRepo.findById(custId).get();
        c.setDob(date);
        return customerRepo.save(c);
    }
}
