package com.etiya.ecommercedemopair4.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCustomerResponse {
    private int id;
    private String companyName;
    private String contactName;
    private String emailAddress;
    private String phoneNumber;
}
