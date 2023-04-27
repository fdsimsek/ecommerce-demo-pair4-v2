package com.etiya.ecommercedemopair4.business.dtos.responses.category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDetailResponse {
    private int id;
    private int parentCategoryId;
    private String categoryName;
}
