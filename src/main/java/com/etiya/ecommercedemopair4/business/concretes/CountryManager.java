package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.CountrySevice;
import com.etiya.ecommercedemopair4.entities.concretes.Country;
import com.etiya.ecommercedemopair4.repositories.abstracts.CountryDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryManager implements CountrySevice {

    private CountryDao countryDao;

    @Override
    public List<Country> getAll() {
        return countryDao.findAll();
    }

    @Override
    public void add(Country country) {

        Country countryToFind = countryDao.findByCountryName(country.getCountryName());
        if (countryToFind != null)
            return;
        countryDao.save(country);

    }
}
