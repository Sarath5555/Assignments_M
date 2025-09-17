package com.example.springdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private String city;
    private String state;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    public Long getId(){ 
        return id; 
    }
    public void setId(Long id){
        this.id = id; 
    }

    public String getStreet(){ 
        return street; 
    }
    public void setStreet(String street){ 
        this.street = street; 
    }

    public String getCity(){ 
        return city; 
    }
    public void setCity(String city){ 
        this.city = city; 
    }

    public String getState(){ 
        return state; 
    }
    public void setState(String state){ 
        this.state = state; 
    }

    public String getPostalCode(){ 
        return postalCode; 
    }
    public void setPostalCode(String postalCode){ 
        this.postalCode = postalCode; 
    }

    public Person getPerson(){
        return person; 
    }
    public void setPerson(Person person){ 
        this.person = person; 
    }
}
