package com.etiya.ecommercedemopair4.business.dtos.requests.shippingMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddShippingMethodRequest {

    private String name;
    private double shippingPrice;

}
