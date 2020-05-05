package com.itcast.sell.repository;

import com.itcast.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author LXQ
 * @create 2019-01-24 15:18
 */
public interface ProductCategoryRepostory extends JpaRepository<ProductCategory,Integer>{

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
