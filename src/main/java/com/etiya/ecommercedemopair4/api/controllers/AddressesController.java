package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.AddressService;
import com.etiya.ecommercedemopair4.entities.concretes.Address;
import com.etiya.ecommercedemopair4.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressesController {

    private AddressService addressService;

    @GetMapping()
    public List<Address> getAll()  {
        return addressService.getAll();
    }

    @PostMapping()
    public void add(Address address) {
        addressService.add(address);
    }

}
