package com.etiya.ecommercedemopair4.business.dtos.requests.product;

import com.etiya.ecommercedemopair4.business.dtos.requests.productCategory.AddProductCategoryRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddProductRequest {
    @NotBlank(message = "{productNameCanNotBeEmpty}")
    @NotNull(message = "{productNameCanNotBeEmpty}")
    //@Length(min = 2, message = "Name alanı 2 karakterden kısa olamaz.")
    @Size(min= 3, max = 50,message = "{nameMustBeBetween}")
    private String name;
    @Min(1)
    private int supplierId;
    private String description;
    private List<AddProductCategoryRequest> productCategory;
}
// Defensive Programming
// Never Trust User Input