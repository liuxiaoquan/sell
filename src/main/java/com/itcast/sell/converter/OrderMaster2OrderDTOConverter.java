package com.itcast.sell.converter;

import com.itcast.sell.dataobject.OrderMaster;
import com.itcast.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LXQ
 * @create 2019-01-28 14:03
 */
public class OrderMaster2OrderDTOConverter {

    public  static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public  static List<OrderDTO> convert(List<OrderMaster> orderMasters){
        List<OrderDTO> orderDTOS = orderMasters.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
        return  orderDTOS;
    }

}
