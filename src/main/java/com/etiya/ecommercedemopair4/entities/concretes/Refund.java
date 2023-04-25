package com.etiya.ecommercedemopair4.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "refund")
@Entity
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "refund_number")
    private int refundNumber;

    @Column(name = "refund_date")
    private Date refundDate;

    @ManyToOne()
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
