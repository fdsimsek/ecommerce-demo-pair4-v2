package com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOrderStatusResponse {
    private int id;
    private String status;
}
