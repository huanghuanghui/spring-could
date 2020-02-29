package com.hhh.product.dao;

import com.hhh.product.entity.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author hhh
 * @date 2020/2/17 16:59
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryDaoTest {


  @Autowired
  private ProductCategoryDao productCategoryDao;

  @Test
  void findProductCategoriesByCategoryTypeIn() {
    List<ProductCategory> productCategories = productCategoryDao.findProductCategoriesByCategoryTypeIn(Arrays.asList(1,2));
    Assert.assertTrue(productCategories.size()>0);
  }
}
