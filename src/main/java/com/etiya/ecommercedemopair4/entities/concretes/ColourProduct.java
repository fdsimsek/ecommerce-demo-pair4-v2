package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "colour_product")
@Entity
public class ColourProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne()
    @JoinColumn(name = "colour_id")
    private Colour colour;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
