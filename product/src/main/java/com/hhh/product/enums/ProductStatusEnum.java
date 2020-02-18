package com.hhh.product.enums;

import lombok.Getter;

/**
 * @author hhh
 * @date 2020/2/17 17:09
 * @Despriction
 */
@Getter
public enum ProductStatusEnum {
  UP(0, "上架"),
  DOWN(1, "下架");

  private Integer code;
  private String description;

  ProductStatusEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }
}
