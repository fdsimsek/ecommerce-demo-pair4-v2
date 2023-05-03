package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.customer.GetByIdCustomerResponse;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.ErrorResult;
import com.etiya.ecommercedemopair4.core.utilities.result.Result;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessResult;
import com.etiya.ecommercedemopair4.repositories.abstracts.CustomerDao;
import com.etiya.ecommercedemopair4.entities.concretes.Customer;
import com.etiya.ecommercedemopair4.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair4.business.dtos.requests.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.customer.GetAllCustomersResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private CustomerDao customerDao;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCustomersResponse> getAll() {

        List<Customer> customers = customerDao.findAll();

        //elimizde bir list yani bir stream varsa tek tek dolaşmanı sağlıuor ve her bir customer için bir mapleme yap
        List<GetAllCustomersResponse> customersResponse = customers.stream()
                .map(customer -> this.modelMapperService.forResponse()
                        .map(customer, GetAllCustomersResponse.class)).collect(Collectors.toList());
                                                                //topla ve şu tipe çevir demek toList

        return customersResponse;
    }

    @Override
    public GetByIdCustomerResponse getById(int id) {
        Customer customer = this.customerDao.findById(id).orElseThrow();

        //Customerı, GetByIdCustomerResponse türünde bir class oluşturup, ona çeviriyo
        GetByIdCustomerResponse response
                = this.modelMapperService.forResponse().map(customer, GetByIdCustomerResponse.class);
        return response;
    }

    @Override
    public void add(AddCustomerRequest addCustomerRequest) {

        //mapper - for request => senin yerine arka planda customerı new liyo,
        // bütün alanları tek tek karşılaştırıyo,
        // aynı olanları newlediğine aktarıyo
        Customer customer = this.modelMapperService.forRequest().map(addCustomerRequest, Customer.class);
        this.customerDao.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        this.customerDao.save(customer);

    }

    @Override
    public void delete(int id) {

        this.customerDao.deleteById(id);

    }

    @Override
    public Result customerWithIdShouldExixts(int customerId) {
        boolean isCustomerExists = customerDao.existsCustomerById(customerId);
        if(isCustomerExists)
            return new SuccessResult();
        return new ErrorResult();
    }
}
