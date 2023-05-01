package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair4.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;

import java.util.List;

public interface ProductService {

    List<ListProductResponse> getAll();

    DataResult<AddProductResponse> add(AddProductRequest addProductRequest);

    DataResult<UpdateProductResponse> update(UpdateProductRequest updateProductRequest);

    ProductDetailResponse getById(int id);
}
