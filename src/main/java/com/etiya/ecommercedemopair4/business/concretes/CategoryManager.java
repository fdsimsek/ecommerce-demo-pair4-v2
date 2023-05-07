package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair4.business.constants.Messages;
import com.etiya.ecommercedemopair4.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair4.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair4.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemopair4.core.internationalization.MessageService;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.*;
import com.etiya.ecommercedemopair4.entities.concretes.Category;
import com.etiya.ecommercedemopair4.repositories.abstracts.CategoryDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryDao categoryDao;
    private final ModelMapperService modelMapperService;

    private final MessageService messageService;

    @Override
    public DataResult<List<ListCategoryResponse>> getAll() {
        return new SuccessDataResult<>(categoryDao.getAll()) ;
    }

    @Override
    public DataResult<Page<ListCategoryResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(categoryDao.getAll(pageable));
    }

    @Override
    public DataResult<AddCategoryResponse> add(AddCategoryRequest addCategoryRequest) throws Exception {
        //validation, business rules
        checkIfCategoryWithSameExists(addCategoryRequest.getCategoryName());
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
        return new DataResult<>(response, true, messageService.getMessage(Messages.Category.CategoryAdded));
    }

    @Override
    public DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest updateCategoryRequest) {
        //verilen id ile bir kategori olup olmadığına bakmak
        //checkIfCategoryWithIdExists(updateCategoryRequest.getId());
        Category category = categoryDao.findById(updateCategoryRequest.getId())
                .orElseThrow(() -> new NotFoundException(
                        messageService.getMessageWithParams(Messages.Category.CategoryDoesNotExistsWithGivenId, updateCategoryRequest.getId())));
        checkIfCategoryWithSameExists(updateCategoryRequest.getCategoryName());

        Category category1 = modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
        categoryDao.save(category1);

        UpdateCategoryResponse response = modelMapperService.forResponse().map(category1, UpdateCategoryResponse.class);
        return new DataResult<>(response, true ,messageService.getMessage(Messages.Category.CategoryUpdated));

    }

    @Override
    public DataResult<CategoryDetailResponse> getById(int id) {
        return new SuccessDataResult<>(categoryDao.getById(id));
    }

    @Override
    public Result categoryWithIdShouldExixts(int categoryId) {
        boolean isCategoryExists = categoryDao.existsCategoryById(categoryId);
        if (isCategoryExists)
            return new SuccessResult();
        return new ErrorResult();
    }

    // iş kuralı
    // iş kuralı metodları ayrı olmalı
    // aynı işlemde 2 kategori olamaz

    // Magic String = xFonksiyonu("Deneme")
    // Constants.java => (Sabitler)
    // SRS => System Requirements

    public void checkIfCategoryWithIdExists(int categoryId) {
        if (!categoryWithIdShouldExixts(categoryId).isSuccess())
            throw new NotFoundException(messageService.getMessage(Messages.Category.CategoryDoesNotExistsWithGivenId));
    }
    public void checkIfCategoryWithSameExists(String categoryName) {
        Category categoryToFind = categoryDao.findByCategoryName(categoryName);
        if(categoryToFind != null)
            // new BusinessException();
            throw new BusinessException(messageService.getMessage(Messages.Category.CategoryExists));
    }
}
