package com.itcast.sell.dto;

import lombok.Data;

/**
 * 购物车传输对象
 * @author LXQ
 * @create 2019-01-28 10:31
 */
@Data
public class CartDTO {
    /** 商品id. **/
    private  String productId;
    /** 商品数量. **/
    private  Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {

        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
