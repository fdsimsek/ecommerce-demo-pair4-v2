package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.AddressService;
import com.etiya.ecommercedemopair4.business.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.entities.concretes.Address;
import com.etiya.ecommercedemopair4.entities.concretes.Category;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressesController {

    private AddressService addressService;

    @GetMapping()
    public List<ListAddressResponse> getAll()  {
        return addressService.getAll();
    }

    @PostMapping()
    public DataResult<AddAddressResponse> add(@Valid @RequestBody AddAddressRequest addAddressRequest) {
       return addressService.add(addAddressRequest);
    }

    @GetMapping("{id}")
    public AddressDetailResponse getById(@PathVariable int id) {
        return  addressService.getById(id);
    }

}
