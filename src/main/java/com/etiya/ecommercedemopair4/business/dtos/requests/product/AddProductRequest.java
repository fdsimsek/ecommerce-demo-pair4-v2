package com.etiya.ecommercedemopair4.business.dtos.requests.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProductRequest {
    @NotBlank(message = "Name alanı boş bırakılamaz")
    @NotNull(message = "Name alanı boş bırakılamaz")
    //@Length(min = 2, message = "Name alanı 2 karakterden kısa olamaz.")
    @Size(min= 2, message = "Name alanı 2 karakterden kısa olamaz.")
    private String name;
    @Min(1)
    private int supplierId;
    private String description;
}
// Defensive Programming
// Never Trust User Input