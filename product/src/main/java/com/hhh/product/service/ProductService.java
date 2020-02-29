package com.hhh.product.service;

import com.hhh.product.entity.ProductInfo;

import java.util.List;

/**
 * @author hhh
 * @date 2020/2/17 17:12
 * @description
 */
public interface ProductService {
  List<ProductInfo> findAllUpProduct();
}
