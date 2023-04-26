package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair4.business.requests.CreateCustomerRequest;
import com.etiya.ecommercedemopair4.business.requests.UpdateCustomerRequest;
import com.etiya.ecommercedemopair4.business.responses.GetAllCustomersResponse;
import com.etiya.ecommercedemopair4.business.responses.GetByIdCustomerResponse;
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

    @GetMapping("/{id}")
    public GetByIdCustomerResponse getById(@PathVariable int id) {
        return customerService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() CreateCustomerRequest createCustomerRequest) {
        this.customerService.add(createCustomerRequest);
    }

    @PutMapping()
    public void update(@RequestBody() UpdateCustomerRequest updateCustomerRequest) {
        this.customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id) {
        this.customerService.delete(id);
    }


}
