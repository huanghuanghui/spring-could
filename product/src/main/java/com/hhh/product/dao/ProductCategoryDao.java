package com.hhh.product.dao;

import com.hhh.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author hhh
 * @date 2020/2/17 16:57
 * @description
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

  List<ProductCategory> findProductCategoriesByCategoryTypeIn(List<Integer> categoryTypeList);
}

