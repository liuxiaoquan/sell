package com.itcast.sell.service.impl;

import com.itcast.sell.dataobject.ProductInfo;
import com.itcast.sell.dto.CartDTO;
import com.itcast.sell.enums.ProductStatusEnum;
import com.itcast.sell.enums.ResultEnum;
import com.itcast.sell.exception.SellException;
import com.itcast.sell.repository.ProductInfoRepository;
import com.itcast.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LXQ
 * @create 2019-01-25 10:49
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new  SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int number = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(number);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new  SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int number = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (number < 0 ){
                throw  new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(number);
            repository.save(productInfo);
        }
    }
}
