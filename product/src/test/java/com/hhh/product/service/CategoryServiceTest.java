package com.hhh.product.service;

import com.hhh.product.SuperTest;
import com.hhh.product.entity.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author hhh
 * @date 2020/2/18 8:46
 * @description
 */
@Component
class CategoryServiceTest extends SuperTest {

  @Autowired
  private CategoryService categoryService;

  @Test
  void findProductCategoriesByCategoryTypeIn() {
    List<ProductCategory> categoryList = categoryService.findProductCategoriesByCategoryTypeIn(Arrays.asList(1,2));
    Assert.assertTrue(categoryList.size()>0);
  }
}
