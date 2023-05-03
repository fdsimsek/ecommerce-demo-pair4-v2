package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.ShippingMethodService;
import com.etiya.ecommercedemopair4.business.constants.Messages;
import com.etiya.ecommercedemopair4.business.dtos.requests.shippingMethod.AddShippingMethodRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod.AddShippingMethodResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod.ListShippingMethodResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.shippingMethod.ShippingMethodDetailResponse;
import com.etiya.ecommercedemopair4.core.internationalization.MessageService;
import com.etiya.ecommercedemopair4.core.utilities.mappers.ModelMapperService;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.core.utilities.result.SuccessDataResult;
import com.etiya.ecommercedemopair4.entities.concretes.ShippingMethod;
import com.etiya.ecommercedemopair4.repositories.abstracts.ShippingMethodDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShippingMethodManager implements ShippingMethodService {

    private final ShippingMethodDao shippingMethodDao;

    private final ModelMapperService modelMapperService;

    private final MessageService messageService;
    @Override
    public DataResult<List<ListShippingMethodResponse>> getAll() {
        return new SuccessDataResult<>(shippingMethodDao.getAll());
    }

    @Override
    public DataResult<Page<ListShippingMethodResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(shippingMethodDao.getAll(pageable));
    }

    @Override
    public DataResult<AddShippingMethodResponse> add(AddShippingMethodRequest addShippingMethodRequest) {

        ShippingMethod shippingMethod = modelMapperService.forRequest().map(addShippingMethodRequest, ShippingMethod.class);
        shippingMethodDao.save(shippingMethod);

        AddShippingMethodResponse response = modelMapperService.forResponse().map(shippingMethod, AddShippingMethodResponse.class);

        return new SuccessDataResult<>(response, messageService.getMessage(Messages.ShippingMethod.ShippingMethodAdded));
    }

    @Override
    public DataResult<ShippingMethodDetailResponse> getById(int id) {
        return new SuccessDataResult<>(shippingMethodDao.getById(id));
    }
}
