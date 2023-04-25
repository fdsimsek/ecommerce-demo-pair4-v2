package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.ParentCategoryService;
import com.etiya.ecommercedemopair4.entities.concretes.ParentCategory;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parentcategories")
@AllArgsConstructor
public class ParentCategoryController {

    private ParentCategoryService parentCategoryService;

    @GetMapping()
    public List<ParentCategory> getAll() {
        return parentCategoryService.getAll();
    }

    @PostMapping()
    public void add(ParentCategory parentCategory) {
        parentCategoryService.add(parentCategory);
    }
}
