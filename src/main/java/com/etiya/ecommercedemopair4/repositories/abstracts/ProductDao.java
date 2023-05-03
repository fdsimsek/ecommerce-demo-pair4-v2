package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair4.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.product" +
            ".ListProductResponse(p.id, p.name, p.description, s.companyName)" +
            " from Product p JOIN p.supplier s")
    List<ListProductResponse> getAll();

    @Query(value = "select new com.etiya.ecommercedemopair4.business.dtos.responses.product" +
            ".ProductDetailResponse(p.id, p.name, p.description, s.id,s.companyName) " +
            "from Product p JOIN p.supplier s where p.id = :id")
    ProductDetailResponse getById(int id);

    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.product" +
            ".ListProductResponse(p.id, p.name, p.description, s.companyName)" +
            " from Product p JOIN p.supplier s")
    Page<ListProductResponse> getAll(Pageable pageable);
}
// Defensive Programming
// Unit-Test
// Sayfalama
// JPQL - SQL
// Multi-Language