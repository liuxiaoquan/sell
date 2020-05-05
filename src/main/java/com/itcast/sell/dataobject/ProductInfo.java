package com.itcast.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品表
 * @author LXQ
 * @create 2019-01-25 10:12
 */
@Entity
@DynamicUpdate//动态更新，解决mysql数据库的自动更新时间问题
@Data
public class ProductInfo {

    /** 商品ID. **/
    @Id
    private String productId;

    /** 商品名称. **/
    private String productName;

    /** 商品价格. **/
    private BigDecimal productPrice;

    /** 库存. **/
    private  Integer productStock;

    /** 描述. **/
    private String productDescription;

    /** 小图. **/
    private String productIcon;

    /** 商品状态,0正常1下架. **/
    private Integer productStatus;

    /** 类目编号. **/
    private Integer categoryType;

    public ProductInfo() {
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }
}
