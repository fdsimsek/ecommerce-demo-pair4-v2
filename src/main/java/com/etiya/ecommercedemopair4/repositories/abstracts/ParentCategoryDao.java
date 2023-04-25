package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.Category;
import com.etiya.ecommercedemopair4.entities.concretes.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentCategoryDao extends JpaRepository<ParentCategory, Integer> {
    ParentCategory findByName(String name);
}
