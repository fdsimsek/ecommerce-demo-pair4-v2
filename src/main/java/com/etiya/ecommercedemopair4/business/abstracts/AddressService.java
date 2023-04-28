package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.ListAddressResponse;

import java.util.List;

public interface AddressService {
    List<ListAddressResponse> getAll();

    AddAddressResponse add(AddAddressRequest addAddressRequest);

    AddressDetailResponse getById(int id);
}
