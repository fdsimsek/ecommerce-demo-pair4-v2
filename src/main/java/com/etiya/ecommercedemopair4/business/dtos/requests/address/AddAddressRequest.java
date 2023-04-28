package com.etiya.ecommercedemopair4.business.dtos.requests.address;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddAddressRequest {
    @NotBlank(message = "Adres alanı boş bırakılamaz")
    @NotNull(message = "Adres alanı boş bırakılamaz")
    private String addressField;
    @NotBlank(message = "Şehir alanı boş bırakılamaz")
    @NotNull(message = "Şehir alanı boş bırakılamaz")
    private String city;
    @NotBlank(message = "Şehir alanı boş bırakılamaz")
    @NotNull(message = "Şehir alanı boş bırakılamaz")
    private String postalCode;
    @Min(1)
    private int countryId;
}
