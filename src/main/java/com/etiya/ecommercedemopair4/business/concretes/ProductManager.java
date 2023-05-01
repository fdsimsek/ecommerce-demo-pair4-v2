package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.ProductService;
import com.etiya.ecommercedemopair4.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair4.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessDataResult;
import com.etiya.ecommercedemopair4.entities.concretes.Product;
import com.etiya.ecommercedemopair4.repositories.abstracts.ProductDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ProductDao productDao;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<AddProductResponse> add(AddProductRequest addProductRequest) {
        //Product nesnesi üretmeniz ve maplememiz
        //Product product = new Product();
        //product.setName(addProductRequest.getName());
        //product.setDescription(addProductRequest.getDescription());

        //Supplier supplier = new Supplier();
        //supplier.setId(addProductRequest.getSupplierId());

        //product.setSupplier(supplier);

        Product product = this.modelMapperService.forRequest().map(addProductRequest, Product.class);
        this.productDao.save(product);

        AddProductResponse response = this.modelMapperService.forResponse().map(product, AddProductResponse.class);
        return new SuccessDataResult<>(response, "Ürün eklendi");
    }

    @Override
    public DataResult<UpdateProductResponse> update(UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
        this.productDao.save(product);

        UpdateProductResponse response = this.modelMapperService.forResponse().map(product, UpdateProductResponse.class);
        return new SuccessDataResult<>(response, "Ürün güncellendi");
    }

    @Override
    public ProductDetailResponse getById(int id) {
        return productDao.getById(id);
    }

    @Override
    public List<ListProductResponse> getAll() {
        return productDao.getAll();
    }
}
