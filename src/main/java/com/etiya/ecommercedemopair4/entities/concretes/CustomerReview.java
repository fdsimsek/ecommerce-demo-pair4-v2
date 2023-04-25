package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_review")
@Entity
public class CustomerReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name = "order_details_id")
    private OrderDetail orderDetail;

    @Column(name = "rating_value")
    private int ratingValue;

    @Column
    private String comment;

    @OneToMany(mappedBy = "customerReview")
    private List<SupplierResponse> supplierResponses;
}
