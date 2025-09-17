package com.example.springdemo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String contactNo;
    private LocalDate dob;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    public Long getId(){ 
        return id; 
    }
    public void setId(Long id){ 
        this.id = id; 
    }

    public String getName(){ 
        return name; 
    }
    public void setName(String name){ 
        this.name = name; 
    }

    public String getContactNo(){ 
        return contactNo; 
    }
    public void setContactNo(String contactNo){ 
        this.contactNo = contactNo; 
    }

    public LocalDate getDob(){ 
        return dob; 
    }
    public void setDob(LocalDate dob){ 
        this.dob = dob; 
    }

    public List<Address> getAddresses(){ 
        return addresses; 
    }
    public void setAddresses(List<Address> addresses){
        this.addresses.clear();
        if (addresses != null) {
            addresses.forEach(a -> a.setPerson(this));
            this.addresses.addAll(addresses);
        }
    }
}
