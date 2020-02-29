package com.hhh.product.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hhh
 * @date 2020/2/18 8:52
 * @description
 */
@Data
public class ResultVO<T> implements Serializable {
  /**
   * 返回码
   */
  private Integer code;

  /**
   * 情求信息
   */
  private String msg;

  /**
   * 内容
   */
  private T data;
}
