package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.ProductService;
import com.etiya.ecommercedemopair4.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair4.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
    private ProductService productService;

    @PostMapping()
    public DataResult<AddProductResponse> add(@Valid @RequestBody AddProductRequest addProductRequest) {
        return productService.add(addProductRequest);
    }

    @PutMapping()
    public DataResult<UpdateProductResponse> update(@Valid @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.update(updateProductRequest);
    }

    @GetMapping()
    public List<ListProductResponse> getAll() {
        return productService.getAll();
    }

    @GetMapping("{id}")
    public ProductDetailResponse getById(@PathVariable int id) {
        return productService.getById(id);
    }

}
