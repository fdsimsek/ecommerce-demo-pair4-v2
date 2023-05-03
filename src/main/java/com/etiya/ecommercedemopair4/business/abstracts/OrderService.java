package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    List<ListOrderResponse> getAll();

    DataResult<Page<ListOrderResponse>> getAllWithPagination(Pageable pageable);

    DataResult<AddOrderResponse> add(AddOrderRequest addOrderRequest);

    OrderDetailResponse getById(int id);
}
