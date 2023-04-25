package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne()
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @ManyToOne()
    @JoinColumn(name = "product_attributes_id")
    private ProductAttribute productAttribute;

    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "product")
    private List<ProductSupplier> productSuppliers;

    @OneToMany(mappedBy = "product")
    private List<ProductItem> productItems;

    @OneToMany(mappedBy = "product")
    private List<ProductCategory> productCategories;
}
