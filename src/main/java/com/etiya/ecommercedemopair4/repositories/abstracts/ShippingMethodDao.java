package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.ShippingMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingMethodDao extends JpaRepository<ShippingMethod, Integer> {
}
