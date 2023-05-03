package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<ListCategoryResponse> getAll();
    DataResult<Page<ListCategoryResponse>> getAllWithPagination(Pageable pageable);

    DataResult<AddCategoryResponse> add(AddCategoryRequest addCategoryRequest) throws Exception;

    DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest updateCategoryRequest);
    CategoryDetailResponse getById(int id);

    Result categoryWithIdShouldExixts(int categoryId);


}
