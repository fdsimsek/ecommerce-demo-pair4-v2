package com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddShippingMethodResponse {

    private int id;
    private String name;
    private double shippingPrice;

}
