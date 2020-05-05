package com.itcast.sell.repository;

import com.itcast.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author LXQ
 * @create 2019-01-25 10:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    ProductInfoRepository repository;

    @Test
    public void save(){
        ProductInfo info=new ProductInfo();
        info.setProductId("12345672");
        info.setProductName("烤鸭");
        info.setProductPrice(new BigDecimal(99.99));
        info.setProductStock(999);
        info.setProductDescription("皮酥肉嫩");
        info.setProductIcon("http://xxxx.jpg");
        info.setProductStatus(0);
        info.setCategoryType(1);
        ProductInfo save = repository.save(info);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> byProductStatus = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,byProductStatus.size());
    }
}