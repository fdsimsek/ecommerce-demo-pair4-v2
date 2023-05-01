package com.etiya.ecommercedemopair4.business.dtos.requests.category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {
    @NotBlank(message = "Değiştirmek istediğiniz kategorinin id sini giriniz")
    @NotNull(message = "Değiştirmek istediğiniz kategorinin id sini giriniz")
    private int id;
    @Min(1)
    private int parentCategoryId;
    @NotBlank(message = "Name alanı boş bırakılamaz")
    @NotNull(message = "Name alanı boş bırakılamaz")
    private String categoryName;
}
