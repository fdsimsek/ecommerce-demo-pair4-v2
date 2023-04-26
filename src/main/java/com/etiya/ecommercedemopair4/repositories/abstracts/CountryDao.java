package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercedemopair4.entities.concretes.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryDao extends JpaRepository<Country, Integer> {
    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.country.ListCountryResponse(C.id, C.countryName) " +
            "from Country C")
    List<ListCountryResponse> getAll();

    @Query(value = "SELECT NEW com.etiya.ecommercedemopair4.business.dtos.responses.country" +
            ".CountryDetailResponse(c.id, c.countryName) " +
            "from Country c where c.id = :id")
    CountryDetailResponse getById(int id);
}
