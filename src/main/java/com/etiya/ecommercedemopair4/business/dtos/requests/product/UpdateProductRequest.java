package com.etiya.ecommercedemopair4.business.dtos.requests.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    @NotBlank(message = "Değiştirmek istediğiniz ürün idsini giriniz")
    @NotNull(message = "Değiştirmek istediğiniz ürün idsini giriniz")
    private int id;
    @NotBlank(message = "Name alanı boş bırakılamaz")
    @NotNull(message = "Name alanı boş bırakılamaz")
    private String name;
    @Min(1)
    private int supplierId;
    private String description;
}
