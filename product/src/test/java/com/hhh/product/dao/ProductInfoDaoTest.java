package com.hhh.product.dao;

import com.hhh.product.entity.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author hhh
 * @date 2020/2/17 16:36
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoDaoTest {

  @Autowired
  private ProductInfoDao productInfoDao;
  @Test
  void findByProductStatus() {
    List<ProductInfo> list = productInfoDao.findProductInfosByProductStatus(1);
    Assert.assertTrue(list.size()>0);
  }

  @Test
  void findByProductIdIn() {
  }
}
