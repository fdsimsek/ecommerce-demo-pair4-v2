package com.etiya.ecommercedemopair4.business.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    private String companyName;
    private String contactName;
    private String emailAddress;
    private String phoneNumber;
    private String password;
}
