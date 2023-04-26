package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair4.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    Category findByCategoryName(String categoryName);
    // JPQL Jpa Query Language => Model ismi kullanır
    // SQL => tablo ismi kullanır
    @Query(value = "SELECT new com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse(c.id, c.parentCategory,c.categoryName) " +
            "from Category  c",
            nativeQuery = false)
    List<ListCategoryResponse> getAll();
}
