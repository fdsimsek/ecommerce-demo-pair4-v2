package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column (name = "address_field")
    private String addressField;

    @Column
    private String city;

    @Column (name = "postal_code")
    private String postalCode;

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "address")
    private List<CustomerAddress> customerAddresses;

    @OneToMany(mappedBy = "shippingAddress")
    private List<Order> orders;

}
