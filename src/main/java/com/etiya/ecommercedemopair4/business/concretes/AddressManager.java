package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.AddressService;
import com.etiya.ecommercedemopair4.business.abstracts.CountrySevice;
import com.etiya.ecommercedemopair4.business.constants.Messages;
import com.etiya.ecommercedemopair4.business.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercedemopair4.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair4.core.internationalization.MessageService;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.*;
import com.etiya.ecommercedemopair4.entities.concretes.Address;
import com.etiya.ecommercedemopair4.repositories.abstracts.AddressDao;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private final AddressDao addressDao;
    private final ModelMapperService modelMapperService;

    private final CountrySevice countrySevice;

    private final MessageService messageService;

    @Override
    public DataResult<List<ListAddressResponse>> getAll() {
        return new SuccessDataResult<>(addressDao.getAll(),messageService.getMessage(Messages.Address.AddressListed));
    }

    @Override
    public DataResult<Page<ListAddressResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(addressDao.getAll(pageable));
    }

    @Override
    public DataResult<AddAddressResponse> add(AddAddressRequest addAddressRequest) {

        // Verilen countryId
        Address address = this.modelMapperService.forRequest().map(addAddressRequest, Address.class);
        countryWithIdShouldExixts(addAddressRequest.getCountryId());
        this.addressDao.save(address);

        AddAddressResponse response = this.modelMapperService.forResponse().map(address, AddAddressResponse.class);
        return new DataResult<>(response, true, messageService.getMessage(Messages.Address.AddressAdded));
    }

    @Override
    public DataResult<AddressDetailResponse> getById(int id) {
        return new SuccessDataResult<>(addressDao.getById(id));
    }

    @Override
    public Result addressWithIdShouldExixts(int addressId) {
        boolean isAddressExists = addressDao.existsAddressById(addressId);
        if (isAddressExists)
            return new SuccessResult();
        return new ErrorResult();
    }

    public void countryWithIdShouldExixts(int countryId) {
        Result countryExists = countrySevice.countryWithIdShouldExixts(countryId);
        if(!countryExists.isSuccess()) {
            throw new BusinessException(messageService.getMessage(Messages.Country.CountryDoesNotExistsWithGivenId));
        }
    }


}
