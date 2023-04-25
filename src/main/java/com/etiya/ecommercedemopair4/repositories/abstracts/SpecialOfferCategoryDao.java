package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.SpecialOfferCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialOfferCategoryDao extends JpaRepository<SpecialOfferCategory, Integer> {
}
