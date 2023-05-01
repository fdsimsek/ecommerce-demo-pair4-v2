package com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderStatusResponse {
    private int id;
    private String status;
}
