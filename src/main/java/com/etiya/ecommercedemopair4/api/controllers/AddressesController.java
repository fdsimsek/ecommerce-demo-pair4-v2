package com.etiya.ecommercedemopair4.api.controllers;

import com.etiya.ecommercedemopair4.business.abstracts.AddressService;
import com.etiya.ecommercedemopair4.business.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressesController {

    private AddressService addressService;

    @GetMapping()
    public DataResult<List<ListAddressResponse>> getAll()  {
        return addressService.getAll();
    }

    @GetMapping("getWithPagination")
    public DataResult<Page<ListAddressResponse>> getAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        //Business katmanı
        return addressService.getAllWithPagination(pageable);
    }

    @PostMapping()
    public DataResult<AddAddressResponse> add(@Valid @RequestBody AddAddressRequest addAddressRequest) {
       return addressService.add(addAddressRequest);
    }

    @GetMapping("{id}")
    public DataResult<AddressDetailResponse> getById(@PathVariable int id) {
        return  addressService.getById(id);
    }

}
