package com.etiya.ecommercedemopair4.business.dtos.responses.shippingmethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingMethodDetailResponse {
    private int id;
    private String name;
    private double shippingPrice;
}
