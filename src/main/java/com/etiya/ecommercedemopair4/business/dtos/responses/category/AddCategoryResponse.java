package com.etiya.ecommercedemopair4.business.dtos.responses.category;

import com.etiya.ecommercedemopair4.entities.concretes.ParentCategory;
import lombok.Data;

@Data
public class AddCategoryResponse {
    private int id;
    private ParentCategory parentCategory;
    private String categoryName;
}
