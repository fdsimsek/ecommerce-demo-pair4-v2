package com.etiya.ecommercedemopair4.business.dtos.responses.order;

import com.etiya.ecommercedemopair4.entities.concretes.Address;
import com.etiya.ecommercedemopair4.entities.concretes.Customer;
import com.etiya.ecommercedemopair4.entities.concretes.OrderStatus;
import com.etiya.ecommercedemopair4.entities.concretes.ShippingMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderResponse {
    private  int id;
    private Date orderDate;
    private int orderTotal;
    private Customer customer;
    private Address address;
    private ShippingMethod shippingMethod;
    private OrderStatus orderStatus;
}
