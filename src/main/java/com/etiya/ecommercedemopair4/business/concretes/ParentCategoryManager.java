package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.ParentCategoryService;
import com.etiya.ecommercedemopair4.business.dtos.requests.parentCategory.AddParentCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.AddParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ListParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ParentCategoryDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.entities.concretes.Category;
import com.etiya.ecommercedemopair4.entities.concretes.ParentCategory;
import com.etiya.ecommercedemopair4.repositories.abstracts.ParentCategoryDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParentCategoryManager implements ParentCategoryService {

    private ParentCategoryDao parentCategoryDao;
    private ModelMapperService modelMapperService;

    @Override
    public List<ListParentCategoryResponse> getAll() {
        return parentCategoryDao.getAll();
    }

    @Override
    public AddParentCategoryResponse add(AddParentCategoryRequest addParentCategoryRequest) {

        ParentCategory parentCategory = modelMapperService.forRequest().map(addParentCategoryRequest, ParentCategory.class);
        parentCategoryDao.save(parentCategory);

        AddParentCategoryResponse response = modelMapperService.forResponse().map(parentCategory, AddParentCategoryResponse.class);
        return response;
    }

    @Override
    public ParentCategoryDetailResponse getById(int id) {
        return parentCategoryDao.getById(id);
    }
}
