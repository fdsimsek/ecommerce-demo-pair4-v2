package com.etiya.ecommercedemopair4.business.dtos.requests.parentCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddParentCategoryRequest {
    @NotBlank(message = "Name alanı boş bırakılamaz")
    @NotNull(message = "Name alanı boş bırakılamaz")
    @Size(min= 2, message = "Name alanı 2 karakterden kısa olamaz.")
    private String parentCategoryName;
}
