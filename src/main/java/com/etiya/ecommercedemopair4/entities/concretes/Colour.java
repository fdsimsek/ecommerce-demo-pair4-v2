package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "colour")
@Entity
public class Colour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column (name = "colour_name")
    private String colourName;

    @OneToMany(mappedBy = "colour")
    private List<ColourProduct> colourProducts;
}
