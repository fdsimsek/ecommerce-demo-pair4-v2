package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair4.business.requests.CreateCustomerRequest;
import com.etiya.ecommercedemopair4.business.responses.GetAllCustomersResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {

    private CustomerService customerService;

    @GetMapping()
    public List<GetAllCustomersResponse> getAll() {
        return customerService.getAll();
    }


    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody() CreateCustomerRequest createCustomerRequest) {
        this.customerService.add(createCustomerRequest);
    }

}
