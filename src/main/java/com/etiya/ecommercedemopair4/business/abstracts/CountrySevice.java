package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.Country;

import java.util.List;

public interface CountrySevice {

    List<Country> getAll();

    void add(Country country);
}
