package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemopair4.business.dtos.requests.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.Result;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessResult;
import com.etiya.ecommercedemopair4.entities.concretes.ProductCategory;
import com.etiya.ecommercedemopair4.repositories.abstracts.ProductCategoryDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductCategoryManager implements ProductCategoryService {
    private ProductCategoryDao productCategoryDao;
    private ModelMapperService modelMapperService;
    @Override
    public Result addRange(int productId, List<AddProductCategoryRequest> addProductCategoryRequests) {
        for (AddProductCategoryRequest request : addProductCategoryRequests) {
            ProductCategory productCategory = modelMapperService.forRequest().map(request, ProductCategory.class);
            productCategory.getProduct().setId(productId);
            productCategoryDao.save(productCategory);
        }
        return new SuccessResult();
    }
}
