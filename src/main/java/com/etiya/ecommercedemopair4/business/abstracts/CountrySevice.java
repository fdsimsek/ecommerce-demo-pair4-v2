package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.country.AddCountryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;

import java.util.List;

public interface CountrySevice {

    List<ListCountryResponse> getAll();

    DataResult<AddCountryResponse> add(AddCountryRequest addCountryRequest);

    CountryDetailResponse getById(int id);
}
