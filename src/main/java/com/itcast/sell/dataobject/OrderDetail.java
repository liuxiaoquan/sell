package com.itcast.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情
 * @author LXQ
 * @create 2019-01-25 15:29
 */
@Entity
@Data
@DynamicUpdate //动态更新，解决mysql数据库的自动更新时间问题
public class OrderDetail {
    /** 订单详情ID. **/
    @Id
    private String detailId;

    /** 订单主表ID. **/
    private String orderId;

    /** 商品表ID. **/
    private String productId;

    /** 商品详情名称. **/
    private String productName;

    /** 商品价格. **/
    private BigDecimal productPrice;

    /** 商品数量. **/
    private Integer productQuantity;

    /** 商品小图. **/
    private String productIcon;

//    /** 创建时间. **/
//    private Date createTime;
//
//    /** 更新时间. **/
//    private Date updateTime;

}
