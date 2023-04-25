package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_details")
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne()
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order order;

    @Column
    private int quantity;

    @Column(name = "total_price")
    private double totalPrice;

    @OneToMany(mappedBy = "orderDetail")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "orderDetail")
    private List<CustomerReview> customerReviews;
}
