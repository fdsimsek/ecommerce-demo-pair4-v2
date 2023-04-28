package com.etiya.ecommercedemopair4.business.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDetailResponse {
    private int id;
    private String addressField;
    private String city;
    private String postalCode;
    private String countryName;
}
