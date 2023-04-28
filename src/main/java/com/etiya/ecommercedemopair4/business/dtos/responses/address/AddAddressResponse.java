package com.etiya.ecommercedemopair4.business.dtos.responses.address;

import com.etiya.ecommercedemopair4.entities.concretes.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressResponse {
    private int id;
    private String addressField;
    private String city;
    private String postalCode;
    private Country country;
}
