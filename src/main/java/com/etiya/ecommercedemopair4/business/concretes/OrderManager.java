package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.OrderService;
import com.etiya.ecommercedemopair4.business.constants.Messages;
import com.etiya.ecommercedemopair4.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair4.core.internationalization.MessageService;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessDataResult;
import com.etiya.ecommercedemopair4.entities.concretes.Order;
import com.etiya.ecommercedemopair4.repositories.abstracts.OrderDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

    private final OrderDao orderDao;

    private final ModelMapperService modelMapperService;

    private final MessageService messageService;

    @Override
    public List<ListOrderResponse> getAll() {
        return orderDao.getAll();
    }

    @Override
    public DataResult<Page<ListOrderResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(orderDao.getAll(pageable));
    }

    @Override
    public DataResult<AddOrderResponse> add(AddOrderRequest addOrderRequest) {

        Order order = modelMapperService.forRequest().map(addOrderRequest, Order.class);
        orderDao.save(order);

        AddOrderResponse response = modelMapperService.forResponse().map(order, AddOrderResponse.class);
        return new SuccessDataResult<>(response, messageService.getMessage(Messages.Order.OrderTaken));
    }

    @Override
    public OrderDetailResponse getById(int id) {
        return orderDao.getById(id);
    }
}
