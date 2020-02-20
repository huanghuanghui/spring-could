package com.hhh.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hhh
 * @date 2020/2/20 16:10
 * @Despriction 调用接口
 */
//name 表示需要访问那个应用的接口
@FeignClient(name = "PRODUCT")
@Component
public interface ProductClient {

  /**
   * 与客户端数据交互
   * @GetMapping 服务提供端暴露的服务接口
   * @return
   */
  @GetMapping("/product-service/msg")
  String productMsg();
}
