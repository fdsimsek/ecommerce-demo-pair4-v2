package com.etiya.ecommercedemopair4.business.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
    private  int id;
    private Date orderDate;
    private int orderTotal;
    private int customerId;
    private int shippingAddressId;
    private int shippingMethodId;
    private int orderStatusId;
}
