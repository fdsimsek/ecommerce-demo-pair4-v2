package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "size")
@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String size;

    @OneToMany(mappedBy = "size")
    private List<SizeProduct> sizeProducts;
}
