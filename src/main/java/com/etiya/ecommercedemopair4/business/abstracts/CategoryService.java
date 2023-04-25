package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    void add(Category category);
}
