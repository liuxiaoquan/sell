package com.itcast.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itcast.sell.dataobject.OrderDetail;
import com.itcast.sell.enums.OrderStatusEnum;
import com.itcast.sell.enums.PayStatusEnum;
import com.itcast.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.criterion.Order;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 数据传输对象,一般包名为dto
 * @author LXQ
 * @create 2019-01-25 16:34
 */
@Data
//返回给前端属性为空null，着去掉改属性,也可以在配置文件（properties）中配置
// spring.jackson.default-property-inclusion=non_null属性
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /** 订单id. **/
    private String orderId;

    /** 买家姓名. **/
    private String buyerName;

    /** 买家电话. **/
    private String buyerPhone;

    /** 买家地址. **/
    private String buyerAddress;

    /** 买家微信openid. **/
    private String buyerOpenid;

    /** 订单总金额. **/
    private BigDecimal orderAmount;

    /** 订单状态,默认0新下单. **/
    private Integer orderStatus;

    /** 支付状态,默认0未支付. **/
    private Integer payStatus;

    /** 创建时间. **/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间. **/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /** 订单详情表. **/
    List<OrderDetail> orderDetailList;
}
