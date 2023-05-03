package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {
    DataResult<List<ListAddressResponse>> getAll();

    DataResult<Page<ListAddressResponse>> getAllWithPagination(Pageable pageable);

    DataResult<AddAddressResponse> add(AddAddressRequest addAddressRequest);

    DataResult<AddressDetailResponse> getById(int id);


}
