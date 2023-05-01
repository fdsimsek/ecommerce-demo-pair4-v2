package com.etiya.ecommercedemopair4.business.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class OrderDetailResponse {
    private  int id;
    private Date orderDate;
    private int orderTotal;
    private int customerId;
    private String customerCompanyName;
    private String addressField;
    private String shippingMethodName;
    private String orderStatusStatus;
}
