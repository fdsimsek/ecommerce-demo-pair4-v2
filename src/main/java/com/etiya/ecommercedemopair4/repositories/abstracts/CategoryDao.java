package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair4.entities.concretes.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    Category findByCategoryName(String categoryName);

    boolean existsCategoryById(int id);

    // JPQL Jpa Query Language => Model ismi kullanır
    // SQL => tablo ismi kullanır
    @Query(value = "SELECT new com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse(c.id, pc.id,c.categoryName) " +
            "from Category  c JOIN c.parentCategory pc",
            nativeQuery = false)
    List<ListCategoryResponse> getAll();

    @Query(value = "select new com.etiya.ecommercedemopair4.business.dtos.responses.category" +
            ".CategoryDetailResponse(c.id, pc.id, c.categoryName) " +
            "from Category c JOIN c.parentCategory pc where c.id = :id")
    CategoryDetailResponse getById(int id);

    @Query(value = "SELECT new com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse(c.id, pc.id,c.categoryName) " +
            "from Category  c JOIN c.parentCategory pc",
            nativeQuery = false)
    Page<ListCategoryResponse> getAll(Pageable pageable);
}
