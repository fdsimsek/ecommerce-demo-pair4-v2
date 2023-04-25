package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_item")
@Entity
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Column(name = "unit_price")
    private double unitPrice;

    @OneToMany(mappedBy = "productItem")
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "productItem")
    private List<OrderDetail> orderDetails;
}
