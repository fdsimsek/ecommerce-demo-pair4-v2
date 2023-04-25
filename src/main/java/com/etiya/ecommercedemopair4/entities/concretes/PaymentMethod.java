package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_method")
@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String provider;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "account_number")
    private int accountNumber;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;

    @ManyToOne()
    @JoinColumn(name = "installment_id")
    private Installment installment;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Invoice> invoices;
}
