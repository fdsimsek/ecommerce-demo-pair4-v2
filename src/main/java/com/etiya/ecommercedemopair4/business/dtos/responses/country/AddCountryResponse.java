package com.etiya.ecommercedemopair4.business.dtos.responses.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCountryResponse {
    private int id;
    private String countryName;
}
