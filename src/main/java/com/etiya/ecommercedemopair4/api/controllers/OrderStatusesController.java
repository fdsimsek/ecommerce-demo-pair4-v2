package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.OrderStatusService;
import com.etiya.ecommercedemopair4.business.dtos.requests.orderstatus.AddOrderStatusRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus.AddOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus.ListOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus.OrderStatusDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderstatuses")
@AllArgsConstructor
public class OrderStatusesController {
    private OrderStatusService orderStatusService;

    @PostMapping()
    public DataResult<AddOrderStatusResponse> add(@Valid @RequestBody AddOrderStatusRequest addOrderStatusRequest) {
        return orderStatusService.add(addOrderStatusRequest);
    }

    @GetMapping()
    public List<ListOrderStatusResponse> getAll() {
        return orderStatusService.getAll();
    }

    @GetMapping("{id}")
    public OrderStatusDetailResponse getById(@PathVariable int id) {
        return orderStatusService.getById(id);
    }
}
