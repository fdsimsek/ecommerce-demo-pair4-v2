package com.etiya.ecommercedemopair4.business.dtos.requests.country;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCountryRequest {
    private String countryName;
}
