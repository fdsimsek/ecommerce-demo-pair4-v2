package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.parentCategory.AddParentCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentcategory.AddParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentcategory.ListParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentcategory.ParentCategoryDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;

import java.util.List;

public interface ParentCategoryService {

    List<ListParentCategoryResponse> getAll();

    DataResult<AddParentCategoryResponse> add(AddParentCategoryRequest addParentCategoryRequest);

    ParentCategoryDetailResponse getById(int id);
}
