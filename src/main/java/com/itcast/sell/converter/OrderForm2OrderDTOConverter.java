package com.itcast.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itcast.sell.dataobject.OrderDetail;
import com.itcast.sell.dto.OrderDTO;
import com.itcast.sell.enums.ResultEnum;
import com.itcast.sell.exception.SellException;
import com.itcast.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LXQ
 * @create 2019-01-28 17:15
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public  static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
             orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
