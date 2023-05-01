package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus.ListOrderStatusResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus.OrderStatusDetailResponse;
import com.etiya.ecommercedemopair4.entities.concretes.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderStatusDao extends JpaRepository<OrderStatus, Integer> {
    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus" +
            ".ListOrderStatusResponse(os.id, os.status)" +
            " from OrderStatus os")
    List<ListOrderStatusResponse> getAll();

    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.orderstatus" +
            ".ListOrderStatusResponse(os.id, os.status)" +
            " from OrderStatus os where os.id = :id")
    OrderStatusDetailResponse getById(int id);
}
