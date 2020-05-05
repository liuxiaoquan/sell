package com.itcast.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author LXQ
 * @create 2019-01-28 16:55
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private  String name;

    /**
     * 买家电话
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家openId
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 买家购物车
     */
    @NotEmpty(message = "购物车必填")
    private String items;
}
