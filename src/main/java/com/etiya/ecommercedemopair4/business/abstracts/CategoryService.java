package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<ListCategoryResponse> getAll();

    AddCategoryResponse add(AddCategoryRequest addCategoryRequest) throws Exception;

    CategoryDetailResponse getById(int id);
}
