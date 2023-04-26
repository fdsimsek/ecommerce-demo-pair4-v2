package com.etiya.ecommercedemopair4.business.dtos.responses.country;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCountryResponse {
    private int id;
    private String countryName;
}
