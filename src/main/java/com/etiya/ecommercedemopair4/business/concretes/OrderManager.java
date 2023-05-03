package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.*;
import com.etiya.ecommercedemopair4.business.constants.Messages;
import com.etiya.ecommercedemopair4.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair4.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair4.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair4.core.internationalization.MessageService;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.Result;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessDataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessResult;
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

    private final CustomerService customerService;

    private final AddressService addressService;

    private final ShippingMethodService shippingMethodService;

    private final OrderStatusService orderStatusService;

    private final MessageService messageService;

    @Override
    public DataResult<List<ListOrderResponse>> getAll() {
        return new SuccessDataResult<>(orderDao.getAll());
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
    public DataResult<UpdateOrderResponse> update(UpdateOrderRequest updateOrderRequest) {
        Order order = this.modelMapperService.forRequest().map(updateOrderRequest, Order.class);
        customerWithIdShouldExixts(updateOrderRequest.getCustomerId());
        addressWithIdShouldExixts(updateOrderRequest.getShippingAddressId());
        shippingMethodWithIdShouldExixts(updateOrderRequest.getShippingMethodId());
        orderStatusWithIdShouldExixts(updateOrderRequest.getOrderStatusId());
        this.orderDao.save(order);

        UpdateOrderResponse response = this.modelMapperService.forResponse().map(order, UpdateOrderResponse.class);
        return new SuccessDataResult<>(response, messageService.getMessage(Messages.Order.OrderUpdated));
    }

    @Override
    public DataResult<OrderDetailResponse> getById(int id) {
        return new SuccessDataResult<>(orderDao.getById(id));
    }

    @Override
    public Result delete(int id) {
        orderDao.deleteById(id);
        return new SuccessResult();
    }

    public void customerWithIdShouldExixts(int customerId) {
        Result countryExists = customerService.customerWithIdShouldExixts(customerId);
        if(!countryExists.isSuccess()) {
            throw new BusinessException(messageService.getMessageWithParams(Messages.Customer.CustomerDoesNotExistsWithGivenId, customerId));
        }
    }

    public void addressWithIdShouldExixts(int addressId) {
        Result addressExists = addressService.addressWithIdShouldExixts(addressId);
        if(!addressExists.isSuccess()) {
            throw new BusinessException(messageService.getMessageWithParams(Messages.Address.AddressDoesNotExistsWithGivenId, addressId));
        }
    }

    public void shippingMethodWithIdShouldExixts(int shippingMethodId) {
        Result shippingMethodExists = shippingMethodService.shippingMethodWithIdShouldExixts(shippingMethodId);
        if(!shippingMethodExists.isSuccess()) {
            throw new BusinessException(messageService.getMessageWithParams(Messages.ShippingMethod.ShippingMethodDoesNotExistsWithGivenId, shippingMethodId));
        }
    }

    public void orderStatusWithIdShouldExixts(int orderStatusId) {
        Result orderStatusExists = orderStatusService.orderStatusWithIdShouldExixts(orderStatusId);
        if(!orderStatusExists.isSuccess()) {
            throw new BusinessException(messageService.getMessageWithParams(Messages.OrderStatus.OrderStatusDoesNotExistsWithGivenId, orderStatusId));
        }
    }
}
