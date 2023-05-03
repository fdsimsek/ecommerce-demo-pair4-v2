package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.CountrySevice;
import com.etiya.ecommercedemopair4.business.constants.Messages;
import com.etiya.ecommercedemopair4.business.dtos.requests.country.AddCountryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercedemopair4.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair4.core.internationalization.MessageService;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.*;
import com.etiya.ecommercedemopair4.entities.concretes.Country;
import com.etiya.ecommercedemopair4.repositories.abstracts.CountryDao;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryManager implements CountrySevice {

    private final CountryDao countryDao;

    private final ModelMapperService modelMapperService;

    private final MessageService messageService;

    @Override
    public List<ListCountryResponse> getAll() {
        return countryDao.getAll();
    }

    @Override
    public DataResult<Page<ListCountryResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(countryDao.getAll(pageable));
    }

    @Override
    public DataResult<AddCountryResponse> add(AddCountryRequest addCountryRequest) {

        checkIfCountryWithSameExists(addCountryRequest.getCountryName());

        Country country = modelMapperService.forRequest().map(addCountryRequest, Country.class);

        countryDao.save(country);

        AddCountryResponse response =  modelMapperService.forResponse().map(country, AddCountryResponse.class);
        return new DataResult<AddCountryResponse>(response, true, messageService.getMessage(Messages.Country.CountryAdded));

    }

    @Override
    public CountryDetailResponse getById(int id) {
        return countryDao.getById(id);
    }

    @Override
    public Result countryWithIdShouldExixts(int countryId) {
        boolean isCountryExists = countryDao.existsCountryById(countryId);
       if(isCountryExists)
           return new SuccessResult();
       return new ErrorResult();
    }

    public void checkIfCountryWithSameExists(String countryName) {
        Country countryToFind = countryDao.findByCountryName(countryName);
        if(countryToFind != null)
            // new BusinessException();
            throw new BusinessException(messageService.getMessage(Messages.Country.CountryExists));
    }
}
