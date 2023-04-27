package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.ColourProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColourProductDao extends JpaRepository<ColourProduct, Integer> {
}
