package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;

import java.util.List;

public interface OrderService {

    List<ListOrderResponse> getAll();

    DataResult<AddOrderResponse> add(AddOrderRequest addOrderRequest);

    OrderDetailResponse getById(int id);
}
