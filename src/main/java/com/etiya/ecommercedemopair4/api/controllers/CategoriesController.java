package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair4.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("getWithPagination")
    public DataResult<Page<ListCategoryResponse>> getAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        //Business katmanı
        return categoryService.getAllWithPagination(pageable);
    }

    @PostMapping()
    public DataResult<AddCategoryResponse> add(@Valid @RequestBody AddCategoryRequest addCategoryRequest) throws Exception{
        return categoryService.add(addCategoryRequest);
    }

    @PutMapping()
    public DataResult<UpdateCategoryResponse> update(@Valid @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return categoryService.update(updateCategoryRequest);
    }

    @GetMapping("{id}")
    public CategoryDetailResponse getById(@PathVariable int id) {
        return categoryService.getById(id);
    }
}
