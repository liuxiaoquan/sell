package com.itcast.sell.exception;

import com.itcast.sell.enums.ResultEnum;

/**
 * @author LXQ
 * @create 2019-01-27 16:58
 */
public class SellException extends RuntimeException{

    private  Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
