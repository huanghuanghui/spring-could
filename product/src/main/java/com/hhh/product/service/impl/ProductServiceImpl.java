package com.hhh.product.service.impl;

import com.hhh.product.dao.ProductInfoDao;
import com.hhh.product.entity.ProductInfo;
import com.hhh.product.enums.ProductStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hhh.product.service.ProductService;

import java.util.List;

/**
 * @author hhh
 * @date 2020/2/17 17:12
 * @description
 */
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductInfoDao productInfoDao;

  @Autowired
  public ProductServiceImpl(ProductInfoDao productInfoDao) {
    this.productInfoDao = productInfoDao;
  }

  @Override
  public List<ProductInfo> findAllUpProduct() {
    return productInfoDao.findProductInfosByProductStatus(ProductStatusEnum.UP.getCode());
  }
}
