package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.OrderService;
import com.etiya.ecommercedemopair4.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrdersController {

    private OrderService orderService;

    @PostMapping()
    public DataResult<AddOrderResponse> add(@Valid @RequestBody AddOrderRequest addOrderRequest) {
        return orderService.add(addOrderRequest);
    }

    @GetMapping()
    public List<ListOrderResponse> getAll() {
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public OrderDetailResponse getById(@PathVariable int id) {
        return orderService.getById(id);
    }
}