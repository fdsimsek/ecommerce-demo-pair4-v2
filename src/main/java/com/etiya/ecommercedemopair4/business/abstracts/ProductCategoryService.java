package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemopair4.core.utilities.result.Result;

import java.util.List;

public interface ProductCategoryService {

    Result addRange(int productId, List<AddProductCategoryRequest> addProductCategoryRequests);
}
