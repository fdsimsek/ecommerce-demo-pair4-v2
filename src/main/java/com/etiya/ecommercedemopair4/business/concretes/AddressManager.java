package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.AddressService;
import com.etiya.ecommercedemopair4.entities.concretes.Address;
import com.etiya.ecommercedemopair4.repositories.abstracts.AddressDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private AddressDao addressDao;

    @Override
    public List<Address> getAll() {
        return addressDao.findAll();
    }

    @Override
    public void add(Address address) {
        Address addressToFind = addressDao.findByAddressField(address.getAddressField());
        if(addressToFind != null)
            return;
        addressDao.save(address);
    }
}
