package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.AddressService;
import com.etiya.ecommercedemopair4.business.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.entities.concretes.Address;
import com.etiya.ecommercedemopair4.repositories.abstracts.AddressDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private AddressDao addressDao;
    private ModelMapperService modelMapperService;

    @Override
    public List<ListAddressResponse> getAll() {
        return addressDao.getAll();
    }

    @Override
    public DataResult<AddAddressResponse> add(AddAddressRequest addAddressRequest) {

        Address address = this.modelMapperService.forRequest().map(addAddressRequest, Address.class);
        this.addressDao.save(address);

        AddAddressResponse response = this.modelMapperService.forResponse().map(address, AddAddressResponse.class);
        return new DataResult<AddAddressResponse>(response, true, "Adres eklendi");
    }

    @Override
    public AddressDetailResponse getById(int id) {
        return addressDao.getById(id);
    }



}
