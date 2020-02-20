package com.hhh.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author hhh
 * @date 2020/2/18 17:16
 * @Despriction
 */
@Component
public class RestTemplateConfig {

  @Bean(name = "restTemplate")
  @LoadBalanced
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
