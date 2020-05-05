package com.itcast.sell.dataobject;

import com.itcast.sell.enums.OrderStatusEnum;
import com.itcast.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单主表
 * @author LXQ
 * @create 2019-01-25 15:09
 */
@Entity
@DynamicUpdate//动态更新，解决mysql数据库的自动更新时间问题
@Data
public class OrderMaster {
    /** 订单id. **/
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态,默认0未支付. **/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间. **/
    private Date createTime;

    /** 更新时间. **/
    private Date updateTime;

    public OrderMaster() {
    }

    public OrderMaster(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenid, BigDecimal orderAmount, Integer orderStatus, Integer payStatus, Date createTime, Date updateTime) {

        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOpenid = buyerOpenid;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


}
