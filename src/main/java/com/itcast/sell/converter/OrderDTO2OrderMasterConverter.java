package com.itcast.sell.converter;

import com.itcast.sell.dataobject.OrderMaster;
import com.itcast.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderDTO转OrderMaster
 * @author LXQ
 * @create 2019-01-28 14:41
 */
public class OrderDTO2OrderMasterConverter {

    public static OrderMaster convert(OrderDTO orderDTO){
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        return orderMaster;
    }

    public static List<OrderMaster> convert(List<OrderDTO> orderDTOList){
        List<OrderMaster> collect = orderDTOList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
        return collect;
    }
}
