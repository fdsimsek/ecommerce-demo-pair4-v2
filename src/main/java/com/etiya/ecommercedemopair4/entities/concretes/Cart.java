package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column (name = "discount_key")
    private String discountKey;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;
}
