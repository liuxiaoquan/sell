package com.itcast.sell.controller;

import com.itcast.sell.VO.ProductInfoVO;
import com.itcast.sell.VO.ProductVO;
import com.itcast.sell.VO.ResultVO;
import com.itcast.sell.dataobject.ProductCategory;
import com.itcast.sell.dataobject.ProductInfo;
import com.itcast.sell.service.CategoryService;
import com.itcast.sell.service.ProductInfoService;
import com.itcast.sell.utils.ResultVOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LXQ
 * @create 2019-01-25 11:22
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    private final Logger logger = LoggerFactory.getLogger(BuyerProductController.class);

    @Autowired
    private ProductInfoService infoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //查询所有上架商品
        List<ProductInfo> upAll = infoService.findUpAll();
        //查询所有类目
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo info : upAll){
//            categoryTypeList.add(info.getCategoryType());
//        }
        //java8的特性（lambda）和注释的是一个意思
        List<Integer> collect = upAll.stream().
                                map(e -> e.getCategoryType())
                                .collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(collect);

        //数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory category :categoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo :upAll){
                if (productInfo.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //spring提供的utils工具可以吧一个类中的值赋值到另一个对象中，前提是这两个类中的属性要对应
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVO(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtils.success(productVOList);
    }
}
