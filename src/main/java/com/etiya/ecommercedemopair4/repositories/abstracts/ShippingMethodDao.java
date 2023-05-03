package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod.ListShippingMethodResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod.ShippingMethodDetailResponse;
import com.etiya.ecommercedemopair4.entities.concretes.ShippingMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShippingMethodDao extends JpaRepository<ShippingMethod, Integer> {

    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod" +
            ".ListShippingMethodResponse(sm.id, sm.name, sm.shippingPrice)" +
            " from ShippingMethod sm")
    List<ListShippingMethodResponse> getAll();

    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod" +
            ".ListShippingMethodResponse(sm.id, sm.name, sm.shippingPrice)" +
            " from ShippingMethod sm where sm.id = :id")
    ShippingMethodDetailResponse getById(int id);

    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod" +
            ".ListShippingMethodResponse(sm.id, sm.name, sm.shippingPrice)" +
            " from ShippingMethod sm")
    Page<ListShippingMethodResponse> getAll(Pageable pageable);
}
