package com.etiya.ecommercedemopair4.business.dtos.requests.product;

import com.etiya.ecommercedemopair4.entities.concretes.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProductRequest {
    private String name;
    private int supplierId;
    private String description;
}
