package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.OrderService;
import com.etiya.ecommercedemopair4.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair4.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrdersController {

    private final OrderService orderService;

    @PostMapping()
    public DataResult<AddOrderResponse> add(@Valid @RequestBody AddOrderRequest addOrderRequest) {
        return orderService.add(addOrderRequest);
    }

    @PutMapping()
    public DataResult<UpdateOrderResponse> update(@Valid @RequestBody UpdateOrderRequest updateOrderRequest) {
        return orderService.update(updateOrderRequest);
    }

    @GetMapping("getWithPagination")
    public DataResult<Page<ListOrderResponse>> getAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        //Business katmanı
        return orderService.getAllWithPagination(pageable);
    }

    @GetMapping()
    public DataResult<List<ListOrderResponse>> getAll() {
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<OrderDetailResponse> getById(@PathVariable int id) {
        return orderService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Result delete(int id) {
        return this.orderService.delete(id);
    }
}
