package com.etiya.ecommercedemopair4.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDetailResponse {
    private int id;
    private String name;
    private String description;
    private int supplierId;
    private String supplierName;
}
