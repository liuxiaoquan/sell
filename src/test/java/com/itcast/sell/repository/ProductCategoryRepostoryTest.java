package com.itcast.sell.repository;

import com.itcast.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author LXQ
 * @create 2019-01-24 15:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepostoryTest {

    @Autowired
    ProductCategoryRepostory repostory;

    @Test
    public void findOneTest(){
        ProductCategory one = repostory.findOne(1);
        System.out.println(one.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory save = repostory.save(new ProductCategory("男生最爱", 1));
        Assert.assertNotNull(save);
    }

    @Test
    public void updateTest(){
        ProductCategory one = repostory.findOne(2);
        one.setCategoryType(3);
        ProductCategory save = repostory.save(one);
        System.out.println(save.toString());
    }

    @Test
    public  void getList(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(10);
        list.add(5);
        List<ProductCategory> byCategoryTypeIn = repostory.findByCategoryTypeIn(list);
        System.out.println(byCategoryTypeIn.toString());
    }
}