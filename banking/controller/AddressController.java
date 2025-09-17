// AddressController.java
package com.example.banking.controller;

import com.example.banking.entity.Address;
import com.example.banking.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }
}
