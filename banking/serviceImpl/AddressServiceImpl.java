// AddressServiceImpl.java
package com.example.banking.serviceImpl;

import com.example.banking.entity.Address;
import com.example.banking.repository.AddressRepository;
import com.example.banking.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepo;

    @Override
    public Address addAddress(Address address) {
        return addressRepo.save(address);
    }
}
