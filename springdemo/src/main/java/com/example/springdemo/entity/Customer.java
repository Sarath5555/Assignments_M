package com.example.springdemo.entity;

import jakarta.persistence.Entity;

@Entity
public class Customer extends Person{
    private String email;
    private String customerNumber;

    public String getEmail(){ 
        return email; 
    }
    public void setEmail(String email){ 
        this.email = email; 
    }

    public String getCustomerNumber(){ 
        return customerNumber; 
    }
    public void setCustomerNumber(String customerNumber){ 
        this.customerNumber = customerNumber; 
    }
}
