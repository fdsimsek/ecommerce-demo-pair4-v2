package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressDao extends JpaRepository<CustomerAddress, Integer> {
}
