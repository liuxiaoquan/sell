package com.itcast.sell.repository;

import com.itcast.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author LXQ
 * @create 2019-01-25 15:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    OrderMasterRepository repository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12346");
        orderMaster.setBuyerName("小明");
        orderMaster.setBuyerPhone("13651449111");
        orderMaster.setBuyerAddress("深圳市福田区");
        orderMaster.setBuyerOpenid("abc");
        orderMaster.setOrderAmount(new BigDecimal(30.23));
        OrderMaster save = repository.save(orderMaster);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0,10);
        Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid("abc", pageRequest);
        Assert.assertNotEquals(0,byBuyerOpenid.getTotalElements());
    }
}