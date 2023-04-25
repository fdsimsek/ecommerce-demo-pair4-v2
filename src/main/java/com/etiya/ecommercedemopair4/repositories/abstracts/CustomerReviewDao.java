package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.CustomerReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerReviewDao extends JpaRepository<CustomerReview, Integer> {
}
