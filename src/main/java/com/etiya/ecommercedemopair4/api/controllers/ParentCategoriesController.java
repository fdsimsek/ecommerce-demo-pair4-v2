package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.ParentCategoryService;
import com.etiya.ecommercedemopair4.business.dtos.requests.parentCategory.AddParentCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.AddParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ListParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ParentCategoryDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parentcategories")
@AllArgsConstructor
public class ParentCategoriesController {

    private final ParentCategoryService parentCategoryService;

    @GetMapping()
    public DataResult<List<ListParentCategoryResponse>> getAll() {
        return parentCategoryService.getAll();
    }

    @PostMapping()
    public DataResult<AddParentCategoryResponse> add(@Valid @RequestBody AddParentCategoryRequest addParentCategoryRequest) {
        return parentCategoryService.add(addParentCategoryRequest);
    }

    @GetMapping("getWithPagination")
    public DataResult<Page<ListParentCategoryResponse>> getAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        //Business katmanı
        return parentCategoryService.getAllWithPagination(pageable);
    }

    @GetMapping("{id}")
    public DataResult<ParentCategoryDetailResponse> getById(@PathVariable int id) {
        return parentCategoryService.getById(id);
    }
}
