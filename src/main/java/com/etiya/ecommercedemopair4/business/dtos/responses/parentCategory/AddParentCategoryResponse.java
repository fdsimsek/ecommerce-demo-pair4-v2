package com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddParentCategoryResponse {
    private int id;
    private String name;
}
