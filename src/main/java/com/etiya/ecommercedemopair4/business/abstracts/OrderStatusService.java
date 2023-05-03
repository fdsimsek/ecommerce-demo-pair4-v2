package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.orderStatus.AddOrderStatusRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.AddOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.ListOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.OrderStatusDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;

import java.util.List;

public interface OrderStatusService {

    List<ListOrderStatusResponse> getAll();

    DataResult<AddOrderStatusResponse> add(AddOrderStatusRequest addOrderStatusRequest);

    OrderStatusDetailResponse getById(int id);
}
