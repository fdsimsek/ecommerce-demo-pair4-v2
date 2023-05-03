package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.parentCategory.AddParentCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.AddParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ListParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ParentCategoryDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ParentCategoryService {

    DataResult<List<ListParentCategoryResponse>> getAll();

    DataResult<Page<ListParentCategoryResponse>> getAllWithPagination(Pageable pageable);

    DataResult<AddParentCategoryResponse> add(AddParentCategoryRequest addParentCategoryRequest);

    DataResult<ParentCategoryDetailResponse> getById(int id);

}
