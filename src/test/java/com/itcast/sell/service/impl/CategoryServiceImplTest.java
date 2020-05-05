package com.itcast.sell.service.impl;

import com.itcast.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author LXQ
 * @create 2019-01-25 9:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    CategoryServiceImpl categoryService;
    @Test
    public void findOne() {
        ProductCategory one = categoryService.findOne(1);
        Assert.assertNotNull(one);
    }

    @Test
    public void findAll() {
        List<ProductCategory> all = categoryService.findAll();
        Assert.assertNotEquals(0,all.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> in = categoryService.findByCategoryTypeIn(Arrays.asList(2, 10, 5));
        Assert.assertNotEquals(0,in.size());
    }

    @Test
    public void save() {
        ProductCategory save = categoryService.save(new ProductCategory("老人最爱", 7));
        Assert.assertNotNull(save);
    }
}