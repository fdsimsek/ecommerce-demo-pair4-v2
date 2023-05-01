package com.etiya.ecommercedemopair4.business.dtos.responses.shippingmethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListShippingMethodResponse {

    private int id;
    private String name;
    private double shippingPrice;


}
