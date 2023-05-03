package com.etiya.ecommercedemopair4.business.dtos.requests.category;

import com.etiya.ecommercedemopair4.business.dtos.requests.productCategory.AddProductCategoryRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {

    @Min(1)
    private int parentCategoryId;
    @NotBlank(message = "{categoryNameCanNotBeEmpty}")
    @NotNull(message = "{categoryNameCanNotBeEmpty}")
    //@Length(min = 2, message = "Name alanı 2 karakterden kısa olamaz.")
    @Size(min= 2, message = "Name alanı 2 karakterden kısa olamaz.")
    private String categoryName;

}
