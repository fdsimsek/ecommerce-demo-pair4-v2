package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.Installment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstallmentDao extends JpaRepository<Installment, Integer> {
}
