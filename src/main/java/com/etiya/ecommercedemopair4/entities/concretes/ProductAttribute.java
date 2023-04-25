package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_attribute")
@Entity
public class ProductAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne()
    @JoinColumn(name = "colour_id")
    private Colour colour;

    @ManyToOne()
    @JoinColumn(name = "size_id")
    private Size size;

    @OneToMany(mappedBy = "productAttribute")
    private List<Product> products;
}
