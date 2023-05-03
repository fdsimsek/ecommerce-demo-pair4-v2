package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.orderStatus.AddOrderStatusRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.AddOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.ListOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.OrderStatusDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderStatusService {

    DataResult<List<ListOrderStatusResponse>> getAll();

    DataResult<Page<ListOrderStatusResponse>> getAllWithPagination(Pageable pageable);

    DataResult<AddOrderStatusResponse> add(AddOrderStatusRequest addOrderStatusRequest);

    DataResult<OrderStatusDetailResponse> getById(int id);
}
