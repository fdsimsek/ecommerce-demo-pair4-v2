package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ProductDetailResponse;

import java.util.List;

public interface ProductService {

    List<ListProductResponse> getAll();

    AddProductResponse add(AddProductRequest addProductRequest);

    ProductDetailResponse getById(int id);
}
