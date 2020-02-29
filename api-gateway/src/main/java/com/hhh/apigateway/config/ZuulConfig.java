package com.hhh.apigateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * @author hhh
 * @date 2020/2/26 17:29
 * @description 配置属性，自动更新zuul属性
 */
public class ZuulConfig {
  @ConfigurationProperties(prefix = "zuul")
  @RefreshScope
  public ZuulProperties zuulProperties(){
    return new ZuulProperties();
  }
}
