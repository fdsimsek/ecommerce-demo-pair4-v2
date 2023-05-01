package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.shippingmethod.AddShippingMethodRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingmethod.AddShippingMethodResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingmethod.ListShippingMethodResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingmethod.ShippingMethodDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;

import java.util.List;

public interface ShippingMethodService {

    List<ListShippingMethodResponse> getAll();

    DataResult<AddShippingMethodResponse> add(AddShippingMethodRequest addShippingMethodRequest);

    ShippingMethodDetailResponse getById(int id);
}
