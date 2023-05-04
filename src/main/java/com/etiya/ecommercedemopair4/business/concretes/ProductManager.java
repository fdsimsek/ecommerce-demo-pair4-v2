package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemopair4.business.abstracts.ProductService;
import com.etiya.ecommercedemopair4.business.constants.Messages;
import com.etiya.ecommercedemopair4.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair4.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercedemopair4.core.internationalization.MessageService;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessDataResult;
import com.etiya.ecommercedemopair4.entities.concretes.Product;
import com.etiya.ecommercedemopair4.repositories.abstracts.ProductDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    private final ModelMapperService modelMapperService;

    private final ProductCategoryService productCategoryService;

    private final MessageService messageService;

    @Override
    public DataResult<AddProductResponse> add(AddProductRequest addProductRequest) {


        Product product = this.modelMapperService.forRequest().map(addProductRequest, Product.class);
        product.setId(0);
        // Verilen categoryId ile bir kategori verisi bulunmalıdır
        // CategoryDao
        // Her bir manager kendi entitysi dışında diğer entitylerin DAO'larını implemente edemez!!
        //        categoryWithIdShouldExists();

        this.productDao.save(product);
        productCategoryService.addRange(product.getId(), addProductRequest.getProductCategory());

        AddProductResponse response = this.modelMapperService.forResponse().map(product, AddProductResponse.class);
        return new SuccessDataResult<>(response, messageService.getMessage(Messages.Product.ProductAdded));
    }

    @Override
    public DataResult<UpdateProductResponse> update(UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
        this.productDao.save(product);

        UpdateProductResponse response = this.modelMapperService.forResponse().map(product, UpdateProductResponse.class);
        return new SuccessDataResult<>(response, messageService.getMessage(Messages.Product.ProductUpdated));
    }

    @Override
    public DataResult<ProductDetailResponse> getById(int id) {
        return new SuccessDataResult<>(productDao.getById(id));
    }

    @Override
    public DataResult<List<ListProductResponse>> getAll() {
        return new SuccessDataResult<>(productDao.getAll());
    }

    @Override
    public DataResult<Page<ListProductResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(productDao.getAll(pageable));
    }
}
//Product nesnesi üretmeniz ve maplememiz
//Product product = new Product();
//product.setName(addProductRequest.getName());
//product.setDescription(addProductRequest.getDescription());

//Supplier supplier = new Supplier();
//supplier.setId(addProductRequest.getSupplierId());

//product.setSupplier(supplier);