package com.itcast.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * http请求返回最外层对象
 * @author LXQ
 * @create 2019-01-25 11:29
 */
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 消息提醒. */
    private String  msg;

    /** 具体内容. */
    private T  data;

}
