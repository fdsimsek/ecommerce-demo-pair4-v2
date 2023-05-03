package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.OrderStatusService;
import com.etiya.ecommercedemopair4.business.constants.Messages;
import com.etiya.ecommercedemopair4.business.dtos.requests.orderStatus.AddOrderStatusRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.AddOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.ListOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.OrderStatusDetailResponse;
import com.etiya.ecommercedemopair4.core.internationalization.MessageService;
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

    private final OrderStatusDao orderStatusDao;

    private final ModelMapperService modelMapperService;

    private final MessageService messageService;

    @Override
    public List<ListOrderStatusResponse> getAll() {
        return orderStatusDao.getAll();
    }

    @Override
    public DataResult<AddOrderStatusResponse> add(AddOrderStatusRequest addOrderStatusRequest) {

        OrderStatus orderStatus = modelMapperService.forRequest().map(addOrderStatusRequest, OrderStatus.class);
        orderStatusDao.save(orderStatus);

        AddOrderStatusResponse response = modelMapperService.forResponse().map(orderStatus, AddOrderStatusResponse.class);

        return new SuccessDataResult<>(response, messageService.getMessage(Messages.OrderStatus.OrderStatusAdded));
    }

    @Override
    public OrderStatusDetailResponse getById(int id) {
        return orderStatusDao.getById(id);
    }
}
