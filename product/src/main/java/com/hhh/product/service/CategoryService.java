package com.hhh.product.service;

import com.hhh.product.entity.ProductCategory;

import java.util.List;

/**
 * @author hhh
 * @date 2020/2/17 17:22
 * @description
 */
public interface CategoryService {
  List<ProductCategory> findProductCategoriesByCategoryTypeIn(List<Integer> categoryTypeList);
}
