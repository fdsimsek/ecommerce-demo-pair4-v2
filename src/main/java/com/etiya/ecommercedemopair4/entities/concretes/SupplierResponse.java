package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier_response")
@Entity
public class SupplierResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "supplier_response")
    private String supplierResponse;

    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne()
    @JoinColumn(name = "customer_review_id")
    private CustomerReview customerReview;


}

