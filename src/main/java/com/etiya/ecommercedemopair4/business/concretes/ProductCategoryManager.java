package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemopair4.business.dtos.requests.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.Result;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessResult;
import com.etiya.ecommercedemopair4.entities.concretes.Category;
import com.etiya.ecommercedemopair4.entities.concretes.Product;
import com.etiya.ecommercedemopair4.entities.concretes.ProductCategory;
import com.etiya.ecommercedemopair4.repositories.abstracts.ProductCategoryDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryManager implements ProductCategoryService {
    private ProductCategoryDao productCategoryDao;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;
    @Override
    public Result addRange(int productId, List<AddProductCategoryRequest> addProductCategoryRequests) {
        for (AddProductCategoryRequest request : addProductCategoryRequests) {
            ProductCategory productCategory = modelMapperService.forRequest().map(request, ProductCategory.class);
            Product product = new Product();
            productCategory.setId(productId);
            productCategory.setProduct(product);
            productCategoryDao.save(productCategory);
        }
        return new SuccessResult();
    }
}
