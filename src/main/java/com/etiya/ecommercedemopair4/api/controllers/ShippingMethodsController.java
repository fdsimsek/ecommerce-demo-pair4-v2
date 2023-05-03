package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.ShippingMethodService;
import com.etiya.ecommercedemopair4.business.dtos.requests.shippingMethod.AddShippingMethodRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod.AddShippingMethodResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod.ListShippingMethodResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod.ShippingMethodDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shippingmethods")
@AllArgsConstructor
public class ShippingMethodsController {

    private ShippingMethodService shippingMethodService;

    @PostMapping()
    public DataResult<AddShippingMethodResponse> add(@Valid @RequestBody AddShippingMethodRequest addShippingMethodRequest) {
        return shippingMethodService.add(addShippingMethodRequest);
    }

    @GetMapping()
    public List<ListShippingMethodResponse> getAll() {
        return shippingMethodService.getAll();
    }

    @GetMapping("{id}")
    public ShippingMethodDetailResponse getById(@PathVariable int id) {
        return shippingMethodService.getById(id);
    }
}
