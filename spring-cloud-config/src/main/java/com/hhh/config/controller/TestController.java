package com.hhh.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhh
 * @date 2020/2/25 16:03
 * @description
 */
@RequestMapping("/v1")
@RestController
public class TestController {
  @GetMapping("/test")
  public String test(){
    return "test";
  }
}
