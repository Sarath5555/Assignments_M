package com.example.springdemo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.springdemo.entity.Customer;
import com.example.springdemo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public Customer addCustomer(Customer customer){
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id){
        return repository.findById(id);
    }

    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer){
        return repository.findById(id).map(customer -> {
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setContactNo(updatedCustomer.getContactNo());
            customer.setDob(updatedCustomer.getDob());
            return repository.save(customer);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public void deleteCustomer(Long id){
        repository.deleteById(id);
    }
}
