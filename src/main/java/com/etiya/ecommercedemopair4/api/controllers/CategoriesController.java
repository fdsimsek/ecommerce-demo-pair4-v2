package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair4.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public AddCategoryResponse add(@Valid @RequestBody AddCategoryRequest addCategoryRequest) throws Exception{
        return categoryService.add(addCategoryRequest);
    }

    @GetMapping("{id}")
    public CategoryDetailResponse getById(@PathVariable int id) {
        return categoryService.getById(id);
    }
}
