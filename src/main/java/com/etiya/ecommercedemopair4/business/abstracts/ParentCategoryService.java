package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.ParentCategory;

import java.util.List;

public interface ParentCategoryService {

    List<ParentCategory> getAll();

    void add(ParentCategory parentCategory);
}
