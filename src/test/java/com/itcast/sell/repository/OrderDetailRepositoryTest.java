package com.itcast.sell.repository;

import com.itcast.sell.dataobject.OrderDetail;
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
 * @create 2019-01-25 16:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12342");
        orderDetail.setOrderId("12346");
        orderDetail.setProductId("1234567");
        orderDetail.setProductName("这是一个商品详情订单");
        orderDetail.setProductPrice(new BigDecimal(199.99));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductIcon("http://xxxx.jpg");
        OrderDetail save = repository.save(orderDetail);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> byOrderId = repository.findByOrderId("1234");
        Assert.assertNotEquals(0,byOrderId.size());
    }
}