package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.ParentCategoryService;
import com.etiya.ecommercedemopair4.business.dtos.requests.parentCategory.AddParentCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentcategory.AddParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentcategory.ListParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentcategory.ParentCategoryDetailResponse;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
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
    public DataResult<AddParentCategoryResponse> add(AddParentCategoryRequest addParentCategoryRequest) {

        ParentCategory parentCategory = this.modelMapperService.forRequest().map(addParentCategoryRequest, ParentCategory.class);
        parentCategoryDao.save(parentCategory);

        AddParentCategoryResponse response = this.modelMapperService.forResponse().map(parentCategory, AddParentCategoryResponse.class);
        return new DataResult<AddParentCategoryResponse>(response, true, "ParentCategory eklendi.");
    }

    @Override
    public ParentCategoryDetailResponse getById(int id) {
        return parentCategoryDao.getById(id);
    }
}
