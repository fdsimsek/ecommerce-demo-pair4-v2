package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//Annotations
//@Getter
//@Setter
@Data
@AllArgsConstructor // => tüm propertyler ile doldurulmuş bir constructor oluşturur
@NoArgsConstructor // => 0 parametreli bir consc. oluşturur.
@Table(name = "product_category")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "parent_category_id")
    private ParentCategory parentCategory;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "category")
    private List<SpecialOfferCategory> specialOfferCategories;
}
