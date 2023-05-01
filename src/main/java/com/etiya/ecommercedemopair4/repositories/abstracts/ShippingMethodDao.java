package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingmethod.ListShippingMethodResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingmethod.ShippingMethodDetailResponse;
import com.etiya.ecommercedemopair4.entities.concretes.ShippingMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShippingMethodDao extends JpaRepository<ShippingMethod, Integer> {

    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.shippingmethod" +
            ".ListShippingMethodResponse(sm.id, sm.name, sm.shippingPrice)" +
            " from ShippingMethod sm")
    List<ListShippingMethodResponse> getAll();

    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.shippingmethod" +
            ".ListShippingMethodResponse(sm.id, sm.name, sm.shippingPrice)" +
            " from ShippingMethod sm where sm.id = :id")
    ShippingMethodDetailResponse getById(int id);

}
