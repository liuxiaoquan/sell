package com.itcast.sell.service;

import com.itcast.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author LXQ
 * @create 2019-01-24 17:27
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
