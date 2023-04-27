package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.SizeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeProductDao extends JpaRepository<SizeProduct, Integer> {
}
