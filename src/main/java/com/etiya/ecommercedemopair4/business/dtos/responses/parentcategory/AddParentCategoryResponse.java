package com.etiya.ecommercedemopair4.business.dtos.responses.parentcategory;

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
