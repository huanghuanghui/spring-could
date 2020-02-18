package com.hhh.product.impl;

import com.hhh.product.SuperTest;
import com.hhh.product.entity.ProductInfo;
import com.hhh.product.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hhh
 * @date 2020/2/17 17:15
 * @Despriction
 */
@Component
class ProductServiceImplTest extends SuperTest {

  @Autowired
  private ProductService productService;

  @Test
  void findAllUpProduct() {
    List<ProductInfo> productInfos = productService.findAllUpProduct();
    Assert.assertTrue(productInfos.size()>0);
  }
}
