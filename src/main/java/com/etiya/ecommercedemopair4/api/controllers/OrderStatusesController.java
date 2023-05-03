package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.OrderStatusService;
import com.etiya.ecommercedemopair4.business.dtos.requests.orderStatus.AddOrderStatusRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.AddOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.ListOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderStatus.OrderStatusDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("getWithPagination")
    public DataResult<Page<ListOrderStatusResponse>> getAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        //Business katmanı
        return orderStatusService.getAllWithPagination(pageable);
    }

    @GetMapping()
    public DataResult<List<ListOrderStatusResponse>> getAll() {
        return orderStatusService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<OrderStatusDetailResponse> getById(@PathVariable int id) {
        return orderStatusService.getById(id);
    }
}
