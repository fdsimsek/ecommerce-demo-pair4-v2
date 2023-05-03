package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.ParentCategoryService;
import com.etiya.ecommercedemopair4.business.constants.Messages;
import com.etiya.ecommercedemopair4.business.dtos.requests.parentCategory.AddParentCategoryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.AddParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ListParentCategoryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.parentCategory.ParentCategoryDetailResponse;
import com.etiya.ecommercedemopair4.core.internationalization.MessageService;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessDataResult;
import com.etiya.ecommercedemopair4.entities.concretes.ParentCategory;
import com.etiya.ecommercedemopair4.repositories.abstracts.ParentCategoryDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParentCategoryManager implements ParentCategoryService {

    private ParentCategoryDao parentCategoryDao;
    private ModelMapperService modelMapperService;

    private MessageService messageService;

    @Override
    public DataResult<List<ListParentCategoryResponse>> getAll() {
        return new SuccessDataResult<>(parentCategoryDao.getAll());
    }

    @Override
    public DataResult<Page<ListParentCategoryResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(parentCategoryDao.getAll(pageable));
    }

    @Override
    public DataResult<AddParentCategoryResponse> add(AddParentCategoryRequest addParentCategoryRequest) {

        ParentCategory parentCategory = this.modelMapperService.forRequest().map(addParentCategoryRequest, ParentCategory.class);
        parentCategoryDao.save(parentCategory);

        AddParentCategoryResponse response = this.modelMapperService.forResponse().map(parentCategory, AddParentCategoryResponse.class);
        return new DataResult<AddParentCategoryResponse>(response, true, messageService.getMessage(Messages.ParentCategory.ParentCategoryAdded));
    }

    @Override
    public DataResult<ParentCategoryDetailResponse> getById(int id) {
        return new SuccessDataResult<>(parentCategoryDao.getById(id));
    }
}
