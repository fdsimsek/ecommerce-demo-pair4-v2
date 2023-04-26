package com.etiya.ecommercedemopair4.business.dtos.requests.category;

import com.etiya.ecommercedemopair4.entities.concretes.ParentCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {
    private ParentCategory parentCategory;
    private String categoryName;
}
