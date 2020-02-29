package com.hhh.product.service.impl;

import com.hhh.product.dao.ProductCategoryDao;
import com.hhh.product.entity.ProductCategory;
import com.hhh.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhh
 * @date 2020/2/17 17:23
 * @description
 */
@Service
public class CategoryServiceImpl implements CategoryService {

  private final ProductCategoryDao categoryDao;

  @Autowired
  public CategoryServiceImpl(ProductCategoryDao categoryDao) {
    this.categoryDao = categoryDao;
  }

  @Override
  public List<ProductCategory> findProductCategoriesByCategoryTypeIn(List<Integer> categoryTypeList) {
    return categoryDao.findProductCategoriesByCategoryTypeIn(categoryTypeList);
  }
}
