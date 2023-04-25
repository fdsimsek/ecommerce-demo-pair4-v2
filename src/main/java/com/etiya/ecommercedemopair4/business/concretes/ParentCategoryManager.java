package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.ParentCategoryService;
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

    @Override
    public List<ParentCategory> getAll() {
        return parentCategoryDao.findAll();
    }

    @Override
    public void add(ParentCategory parentCategory) {

        ParentCategory parentCategoryToFind = parentCategoryDao.findByName(parentCategory.getName());
        if(parentCategoryToFind != null)
            return;
        parentCategoryDao.save(parentCategory);

    }
}
