package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.shippingMethod.AddShippingMethodRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod.AddShippingMethodResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod.ListShippingMethodResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod.ShippingMethodDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShippingMethodService {

    DataResult<List<ListShippingMethodResponse>> getAll();

    DataResult<Page<ListShippingMethodResponse>> getAllWithPagination(Pageable pageable);
    DataResult<AddShippingMethodResponse> add(AddShippingMethodRequest addShippingMethodRequest);

    DataResult<ShippingMethodDetailResponse> getById(int id);

    Result shippingMethodWithIdShouldExixts(int shippingMethodId);
}
