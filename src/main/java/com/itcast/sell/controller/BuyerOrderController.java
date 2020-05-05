package com.itcast.sell.controller;

import com.itcast.sell.VO.ResultVO;
import com.itcast.sell.converter.OrderForm2OrderDTOConverter;
import com.itcast.sell.dto.OrderDTO;
import com.itcast.sell.enums.ResultEnum;
import com.itcast.sell.exception.SellException;
import com.itcast.sell.form.OrderForm;
import com.itcast.sell.service.OrderService;
import com.itcast.sell.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LXQ
 * @create 2019-01-28 16:45
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw  new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.info("【创建订单】购物车不能为空");
            throw  new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtils.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("【订单查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page,size);
        Page<OrderDTO> list = orderService.findList(openid, pageRequest);
        return  ResultVOUtils.success(list.getContent());
    }
    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){
        if (StringUtils.isEmpty(openid)){
            log.error("【订单详情查询】openid为空");
            throw  new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO one = orderService.findOne(orderId);
        if (one ==null){
            log.error("【订单详情查询】查询OrderDTO为空. orderid={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!one.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【订单详情查询】订单的openid不一致. openid={},orderDTO={}",openid,one);
            throw  new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return ResultVOUtils.success(one);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
        if (StringUtils.isEmpty(openid)){
            log.error("【订单详情查询】openid为空");
            throw  new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO ==null){
            log.error("【订单详情查询】查询OrderDTO为空. orderid={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【订单详情查询】订单的openid不一致. openid={},orderDTO={}",openid,orderDTO);
            throw  new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        orderService.cancel(orderDTO);
        return ResultVOUtils.success();
    }
}
