package com.hhh.product.dao;

import com.hhh.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo, Integer> {

    List<ProductInfo> findProductInfosByProductStatus(Integer productStatus);

    List<ProductInfo> findByIdIn(List<Integer> ids);
}
