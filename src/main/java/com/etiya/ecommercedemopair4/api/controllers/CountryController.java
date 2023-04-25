package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.CountrySevice;
import com.etiya.ecommercedemopair4.entities.concretes.Country;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountryController {

    private CountrySevice countrySevice;

    @GetMapping()
    public List<Country> getAll() {
        return countrySevice.getAll();
    }

    @PostMapping()
    public void add(Country country) {
        countrySevice.add(country);
    }
}
