package com.etiya.ecommercedemopair4.business.dtos.requests.address;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddAddressRequest {
    @NotBlank(message = "{addressCanNotBeEmpty}")
    @NotNull(message = "{addressCanNotBeEmpty}")
    private String addressField;
    @NotBlank(message = "{cityCanNotBeEmpty}")
    @NotNull(message = "{cityCanNotBeEmpty}")
    private String city;
    @NotBlank(message = "{postalCodeCanNotBeEmpty}")
    @NotNull(message = "{postalCodeCanNotBeEmpty}")
    private String postalCode;
    @Min(1)
    private int countryId;
}
