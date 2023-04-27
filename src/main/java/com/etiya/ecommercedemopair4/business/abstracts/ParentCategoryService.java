package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.parentCategory.AddParentCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.AddParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ListParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ParentCategoryDetailResponse;

import java.util.List;

public interface ParentCategoryService {

    List<ListParentCategoryResponse> getAll();

    AddParentCategoryResponse add(AddParentCategoryRequest addParentCategoryRequest);

    ParentCategoryDetailResponse getById(int id);
}
