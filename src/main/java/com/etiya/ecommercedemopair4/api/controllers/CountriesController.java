package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.CountrySevice;
import com.etiya.ecommercedemopair4.business.dtos.requests.country.AddCountryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountriesController {

    private CountrySevice countrySevice;

    @GetMapping()
    public List<ListCountryResponse> getAll() {
        return countrySevice.getAll();
    }

    @PostMapping()
    public DataResult<AddCountryResponse> add(@Valid @RequestBody AddCountryRequest addCountryRequest) {
        return countrySevice.add(addCountryRequest);
    }

    @GetMapping("{id}")
    public CountryDetailResponse getById(@PathVariable int id) {
        return countrySevice.getById(id);
    }
}
