package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.orderstatus.AddOrderStatusRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus.AddOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus.ListOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus.OrderStatusDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;

import java.util.List;

public interface OrderStatusService {

    List<ListOrderStatusResponse> getAll();

    DataResult<AddOrderStatusResponse> add(AddOrderStatusRequest addOrderStatusRequest);

    OrderStatusDetailResponse getById(int id);
}
