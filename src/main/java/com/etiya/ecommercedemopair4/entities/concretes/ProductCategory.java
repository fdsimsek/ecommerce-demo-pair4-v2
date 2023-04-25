package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor // => tüm propertyler ile doldurulmuş bir constructor oluşturur
@NoArgsConstructor // => 0 parametreli bir consc. oluşturur.
@Table(name = "product_category")
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
