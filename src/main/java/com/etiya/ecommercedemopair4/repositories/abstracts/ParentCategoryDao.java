package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ListParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ParentCategoryDetailResponse;
import com.etiya.ecommercedemopair4.entities.concretes.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParentCategoryDao extends JpaRepository<ParentCategory, Integer> {
    ParentCategory findByName(String name);

    @Query(value = "SELECT new " +
            "com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory" +
            ".ListParentCategoryResponse(pc.id, pc.name)" +
            " from ParentCategory pc")
    List<ListParentCategoryResponse> getAll();

    @Query(value = "select new com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory" +
            ".ParentCategoryDetailResponse(pc.id, pc.name) " +
            "from ParentCategory pc where pc.id = :id")
    ParentCategoryDetailResponse getById(int id);
}
