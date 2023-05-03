package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercedemopair4.entities.concretes.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressDao extends JpaRepository<Address, Integer> {

    Address findByAddressField(String addressField);

    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.address" +
            ".ListAddressResponse(a.id, a.addressField, a.city, a.postalCode, c.countryName)" +
            " from Address a JOIN a.country c")
    List<ListAddressResponse> getAll();

    @Query(value = "select new com.etiya.ecommercedemopair4.business.dtos.responses.address" +
            ".AddressDetailResponse(a.id, a.addressField, a.city, a.postalCode, c.countryName)" +
            "from Address a JOIN a.country c where a.id = :id")
    AddressDetailResponse getById(int id);

    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.address" +
            ".ListAddressResponse(a.id, a.addressField, a.city, a.postalCode, c.countryName)" +
            " from Address a JOIN a.country c")
    Page<ListAddressResponse> getAll(Pageable pageable);

    boolean existsAddressById(int addressId);
}
