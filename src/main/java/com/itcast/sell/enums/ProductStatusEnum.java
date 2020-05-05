package com.itcast.sell.enums;

/**
 * 商品状态
 * @author LXQ
 * @create 2019-01-25 10:51
 */
public enum ProductStatusEnum {
    UP(0,"上架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {

        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
