package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.requests.CreateCustomerRequest;
import com.etiya.ecommercedemopair4.business.responses.GetAllCustomersResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    void add(CreateCustomerRequest createCustomerRequest);
}
