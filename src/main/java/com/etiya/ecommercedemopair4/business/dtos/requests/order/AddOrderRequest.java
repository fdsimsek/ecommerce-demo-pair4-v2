package com.etiya.ecommercedemopair4.business.dtos.requests.order;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AddOrderRequest {

    private Date orderDate;
    private int orderTotal;
    @Min(1)
    private int customerId;
    @Min(1)
    private int shippingAddressId;
    @Min(1)
    private int shippingMethodId;
    @Min(1)
    private int orderStatusId;
}
