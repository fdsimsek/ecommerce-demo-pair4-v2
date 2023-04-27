package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.ParentCategoryService;
import com.etiya.ecommercedemopair4.business.dtos.requests.parentCategory.AddParentCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.AddParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ListParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ParentCategoryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair4.entities.concretes.ParentCategory;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parentcategories")
@AllArgsConstructor
public class ParentCategoriesController {

    private ParentCategoryService parentCategoryService;

    @GetMapping()
    public List<ListParentCategoryResponse> getAll() {
        return parentCategoryService.getAll();
    }

    @PostMapping()
    public AddParentCategoryResponse add(@Valid AddParentCategoryRequest addParentCategoryRequest) {
        return parentCategoryService.add(addParentCategoryRequest);
    }

    @GetMapping("{id}")
    public ParentCategoryDetailResponse getById(@PathVariable int id) {
        return parentCategoryService.getById(id);
    }
}
