package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair4.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.order" +
            ".ListOrderResponse(o.id, o.orderDate, o.orderTotal, c.id, c.companyName, sa.addressField, sm.name, os.status)" +
            " from Order o JOIN o.customer c JOIN o.shippingAddress sa JOIN o.shippingMethod sm JOIN o.orderStatus os")
    List<ListOrderResponse> getAll();

    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.order" +
            ".ListOrderResponse(o.id, o.orderDate, o.orderTotal, c.id, c.companyName, sa.addressField, sm.name, os.status)" +
            " from Order o JOIN o.customer c JOIN o.shippingAddress sa JOIN o.shippingMethod sm JOIN o.orderStatus os " +
            "where o.id = :id")
    OrderDetailResponse getById(int id);
}
