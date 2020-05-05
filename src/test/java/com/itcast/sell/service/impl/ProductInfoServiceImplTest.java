package com.itcast.sell.service.impl;

import com.itcast.sell.dataobject.ProductInfo;
import com.itcast.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author LXQ
 * @create 2019-01-25 10:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    @Autowired
    private ProductInfoServiceImpl infoService;
    @Test
    public void findOne() {
        ProductInfo one = infoService.findOne("1234567");
        Assert.assertNotNull(one);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = infoService.findUpAll();
        Assert.assertNotEquals(0,upAll.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0,10);
        Page<ProductInfo> all = infoService.findAll(pageRequest);
        long totalElements = all.getTotalElements();
        Assert.assertNotEquals(0,totalElements);
    }

    @Test
    public void save() {
        ProductInfo info=new ProductInfo();
        info.setProductId("123456");
        info.setProductName("烤鸡");
        info.setProductPrice(new BigDecimal(99.99));
        info.setProductStock(999);
        info.setProductDescription("皮酥肉嫩");
        info.setProductIcon("http://xxxx.jpg");
        info.setProductStatus(ProductStatusEnum.DOWN.getCode());
        info.setCategoryType(10);
        ProductInfo save = infoService.save(info);
        Assert.assertNotNull(save);
    }

    @Test
    public void findOne1() {
    }

    @Test
    public void findUpAll1() {
    }

    @Test
    public void findAll1() {
    }

    @Test
    public void save1() {
    }

    @Test
    public void increaseStock() {
    }

    @Test
    public void decreaseStock() {
    }
}