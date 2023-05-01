package com.etiya.ecommercedemopair4.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponse {
    private int id;
    private String name;
    private int supplierId;
    private String description;

}
