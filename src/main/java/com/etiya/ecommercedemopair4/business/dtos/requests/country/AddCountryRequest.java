package com.etiya.ecommercedemopair4.business.dtos.requests.country;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCountryRequest {
    @NotBlank(message = "{countryNameCanNotBeEmpty}")
    @NotNull(message = "{countryNameCanNotBeEmpty}")
    private String countryName;
}
