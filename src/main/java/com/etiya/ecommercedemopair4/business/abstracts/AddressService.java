package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;

import java.util.List;

public interface AddressService {
    List<ListAddressResponse> getAll();

    DataResult<AddAddressResponse> add(AddAddressRequest addAddressRequest);

    AddressDetailResponse getById(int id);
}
