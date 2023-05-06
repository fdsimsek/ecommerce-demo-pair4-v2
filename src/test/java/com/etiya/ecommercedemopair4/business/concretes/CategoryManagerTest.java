package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.constants.Messages;
import com.etiya.ecommercedemopair4.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair4.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair4.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemopair4.core.internationalization.MessageManager;
import com.etiya.ecommercedemopair4.core.internationalization.MessageService;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperManager;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessDataResult;
import com.etiya.ecommercedemopair4.entities.concretes.Category;
import com.etiya.ecommercedemopair4.entities.concretes.ParentCategory;
import com.etiya.ecommercedemopair4.repositories.abstracts.CategoryDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CategoryManagerTest {

    CategoryDao categoryDao;
    ModelMapperService modelMapperService;
    MessageService messageService;

    MessageSource messageSource;
    CategoryManager categoryManager;

    // Mockito
    @BeforeEach
    void setUp() {
        // Her test öncesi çalıştırılacak alan
        modelMapperService = new ModelMapperManager(new ModelMapper());
        messageSource = getBundleMessageSource();
        messageService = new MessageManager(messageSource);
        categoryDao = mock(CategoryDao.class);
        categoryManager = new CategoryManager(categoryDao, modelMapperService, messageService);
    }

    ResourceBundleMessageSource getBundleMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @AfterEach
    void tearDown() {
        // Her test sonrası çalıştırılacak alan
    }

    @Test
    void add() {
        // 3A Principle
        // 3A prensibi

        // Arrange, Act, Assert

        // Arrange => Testimin yapılacağı alanın hazırlanması. Örn. Mock objelerin oluşturulması, bağımlılıkların yükelenmesi

        // Act (Action) => CategoryManager.Add(); (Test edeceğim metodu işlemi işleme almak.)

        // Assert (Beklenti) => Expected durum ile Actual durum karşılaştırılmasının yapıldığı nokta.
        // categoryManager.add().throwsException() ? boolean
    }

    @Test
    void getAll() {
        // mock
        List<ListCategoryResponse> expectedData = new ArrayList<>();
        expectedData.add(new ListCategoryResponse(1,1,"Giyim"));
        expectedData.add(new ListCategoryResponse(1,1,"Deneme"));

        DataResult<List<ListCategoryResponse>> expectedDataResult = new SuccessDataResult<>(expectedData);

        when(categoryDao.getAll()).thenReturn(expectedDataResult.getData());
        DataResult<List<ListCategoryResponse>> actualResult = categoryManager.getAll();

        assert actualResult.getData().size() == expectedDataResult.getData().size();
    }

    @Test
    void updateWithNonExistingIdShouldThrowException() {
        // findById
        when(categoryDao.findById(any())).thenReturn(Optional.ofNullable(null));
        UpdateCategoryRequest request = new UpdateCategoryRequest(8, 1,"Giyim");
        categoryManager.update(request);
        assertThrows(NotFoundException.class,()->{
            categoryManager.update(request);
        });

        // Mocklamada parametreler
    }

    @Test
    void updateWithSameNameShouldThrowException(){
        when(categoryDao.findById(any())).thenReturn(Optional.of(new Category()));
        when(categoryDao.findByCategoryName(any())).thenReturn(new Category());
        UpdateCategoryRequest request = new UpdateCategoryRequest(2,2,"Deneme");
        assertThrows(BusinessException.class, () -> { categoryManager.update(request); });
    }

    @Test
    void update(){
        when(categoryDao.findById(any())).thenReturn(Optional.of(new Category()));
        when(categoryDao.findByCategoryName(any())).thenReturn(null);

        UpdateCategoryRequest request = new UpdateCategoryRequest(4,1,"Deneme");

        DataResult<UpdateCategoryResponse> actualResponse = categoryManager.update(request);
        ParentCategory parentCategory = new ParentCategory();
        SuccessDataResult<UpdateCategoryResponse> expectedResponse =
                new SuccessDataResult<>(new UpdateCategoryResponse(4, parentCategory,"Deneme"));
        assert actualResponse.equals(expectedResponse);
    }
}