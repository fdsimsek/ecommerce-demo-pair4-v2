package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemDao extends JpaRepository<ProductItem, Integer> {
}
