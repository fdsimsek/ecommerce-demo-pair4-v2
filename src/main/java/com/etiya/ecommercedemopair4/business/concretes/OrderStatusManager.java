package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.OrderStatusService;
import com.etiya.ecommercedemopair4.business.dtos.requests.orderstatus.AddOrderStatusRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus.AddOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus.ListOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus.OrderStatusDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessDataResult;
import com.etiya.ecommercedemopair4.entities.concretes.OrderStatus;
import com.etiya.ecommercedemopair4.repositories.abstracts.OrderStatusDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderStatusManager implements OrderStatusService {

    private OrderStatusDao orderStatusDao;

    private ModelMapperService modelMapperService;

    @Override
    public List<ListOrderStatusResponse> getAll() {
        return orderStatusDao.getAll();
    }

    @Override
    public DataResult<AddOrderStatusResponse> add(AddOrderStatusRequest addOrderStatusRequest) {

        OrderStatus orderStatus = modelMapperService.forRequest().map(addOrderStatusRequest, OrderStatus.class);
        orderStatusDao.save(orderStatus);

        AddOrderStatusResponse response = modelMapperService.forResponse().map(orderStatus, AddOrderStatusResponse.class);

        return new SuccessDataResult<>(response, "Sipariş statüsü eklendi");
    }

    @Override
    public OrderStatusDetailResponse getById(int id) {
        return orderStatusDao.getById(id);
    }
}
