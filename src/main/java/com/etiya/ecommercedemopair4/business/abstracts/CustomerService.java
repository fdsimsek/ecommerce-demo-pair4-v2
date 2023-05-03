package com.etiya.ecommercedemopair4.business.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.requests.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair4.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.customer.GetAllCustomersResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.customer.GetByIdCustomerResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.Result;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    GetByIdCustomerResponse getById(int id);
    void add(AddCustomerRequest addCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest);
    void delete(int id);

    Result customerWithIdShouldExixts(int customerId);
}
