package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair4.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair4.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {

    private CategoryService categoryService;

    @GetMapping()
    public List<ListCategoryResponse> getAll() {
        //Business katmanı
        return categoryService.getAll();
    }

    @PostMapping()
    public AddCategoryResponse add(AddCategoryRequest addCategoryRequest) throws Exception{
        return categoryService.add(addCategoryRequest);
    }

}
