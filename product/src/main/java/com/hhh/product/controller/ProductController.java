package com.hhh.product.controller;

import com.hhh.product.VO.ProductInfoVO;
import com.hhh.product.VO.ProductVO;
import com.hhh.product.VO.ResultVO;
import com.hhh.product.entity.ProductCategory;
import com.hhh.product.entity.ProductInfo;
import com.hhh.product.service.CategoryService;
import com.hhh.product.service.ProductService;
import com.hhh.product.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hhh
 * @date 2020/2/17 17:04
 * @Despriction
 */
@RestController
@RequestMapping("/product")
public class ProductController {

  private final ProductService productService;

  private final CategoryService categoryService;

  @Autowired
  public ProductController(ProductService productService, CategoryService categoryService) {
    this.productService = productService;
    this.categoryService = categoryService;
  }

  /**
   * 1. 查询所有在架的商品
   * 2. 获取类目type列表
   * 3. 查询类目
   * 4. 构造数据
   */
  @GetMapping("/list")
  public ResultVO<ProductVO> list() {
    //1. 查询所有在架的商品
    List<ProductInfo> productInfoList = productService.findAllUpProduct();

    //2. 获取类目type列表
    List<Integer> categoryTypeList = productInfoList.stream()
      .map(ProductInfo::getCategoryType)
      .collect(Collectors.toList());

    //3. 从数据库查询类目
    List<ProductCategory> categoryList = categoryService.findProductCategoriesByCategoryTypeIn(categoryTypeList);

    //4. 构造数据
    List<ProductVO> productVOList = new ArrayList<>();
    for (ProductCategory productCategory : categoryList) {
      ProductVO productVO = new ProductVO();
      productVO.setCategoryName(productCategory.getCategoryName());
      productVO.setCategoryType(productCategory.getCategoryType());

      List<ProductInfoVO> productInfoVOList = new ArrayList<>();
      for (ProductInfo productInfo : productInfoList) {
        if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
          ProductInfoVO productInfoVO = new ProductInfoVO();
          BeanUtils.copyProperties(productInfo, productInfoVO);
          productInfoVOList.add(productInfoVO);
        }
      }
      productVO.setProductInfoVOList(productInfoVOList);
      productVOList.add(productVO);
    }

    return ResultVOUtil.success(productVOList);
  }

//  /**
//   * 获取商品列表(给订单服务用的)
//   *
//   * @param productIdList
//   * @return
//   */
//  @PostMapping("/listForOrder")
//  public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
//    try {
//      Thread.sleep(2000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    return productService.findList(productIdList);
//  }
//
//  @PostMapping("/decreaseStock")
//  public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
//    productService.decreaseStock(decreaseStockInputList);
//}
}
