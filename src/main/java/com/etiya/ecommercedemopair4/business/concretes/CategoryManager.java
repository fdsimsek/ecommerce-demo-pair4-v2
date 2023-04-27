package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair4.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair4.core.exceptions.BusinessException;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.entities.concretes.Category;
import com.etiya.ecommercedemopair4.repositories.abstracts.CategoryDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;
    private ModelMapperService modelMapperService;

    @Override
    public List<ListCategoryResponse> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public AddCategoryResponse add(AddCategoryRequest addCategoryRequest) throws Exception {
        //validation, business rules
        Category categoryToFind = categoryDao.findByCategoryName(addCategoryRequest.getCategoryName());
        if(categoryToFind != null)
            // new BusinessException();
            throw new BusinessException("Böyle bir kategori zaten mevcut");
        //Category oluşturmam gerekli

        //AddCategoryRequest => Category => AddCategoryResponse
        //Manual Mapping => Auto Mapping => ModelMapper
//        Category category = new Category();
//        category.setCategoryName(addCategoryRequest.getCategoryName());
//        category.setParentCategory(addCategoryRequest.getParentCategory());

        //Auto Mapping
        Category category = modelMapperService.forRequest().map(addCategoryRequest, Category.class);
        categoryDao.save(category);

        //Manual
//        AddCategoryResponse response = new AddCategoryResponse();
//        response.setId((category.getId()));
//        response.setCategoryName(category.getCategoryName());
        //Auto
        AddCategoryResponse response = modelMapperService.forResponse().map(category, AddCategoryResponse.class);
        return response;
    }

    @Override
    public CategoryDetailResponse getById(int id) {
        return categoryDao.getById(id);
    }
}
