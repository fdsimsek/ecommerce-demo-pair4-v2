package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.ProductSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSupplierDao extends JpaRepository<ProductSupplier, Integer> {
}
