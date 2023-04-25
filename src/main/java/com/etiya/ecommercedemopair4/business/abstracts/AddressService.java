package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAll();

    void add(Address address);
}
