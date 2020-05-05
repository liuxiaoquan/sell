package com.itcast.sell.service.impl;

import com.itcast.sell.dataobject.ProductCategory;
import com.itcast.sell.repository.ProductCategoryRepostory;
import com.itcast.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LXQ
 * @create 2019-01-25 9:46
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepostory repostory;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repostory.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repostory.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repostory.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repostory.save(productCategory);
    }
}
