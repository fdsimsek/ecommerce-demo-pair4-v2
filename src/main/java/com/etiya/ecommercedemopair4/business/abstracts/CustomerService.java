package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.requests.CreateCustomerRequest;
import com.etiya.ecommercedemopair4.business.requests.UpdateCustomerRequest;
import com.etiya.ecommercedemopair4.business.responses.GetAllCustomersResponse;
import com.etiya.ecommercedemopair4.business.responses.GetByIdCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    GetByIdCustomerResponse getById(int id);
    void add(CreateCustomerRequest createCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest);
    void delete(int id);
}
