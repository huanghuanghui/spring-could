package com.hhh.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhh
 * @date 2020/2/18 16:12
 * @Despriction
 */
@RestController
@RequestMapping("/product-service")
public class ServiceController {

  @GetMapping("/msg")
  public String msg(){
    return "this is product msg";
  }
}
