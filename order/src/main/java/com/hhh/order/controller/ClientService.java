package com.hhh.order.controller;

import com.hhh.order.client.ProductClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hhh
 * @date 2020/2/18 16:43
 * @description 服务间的通讯
 */
@RestController
@RequestMapping("/order-client")
@Log4j2
public class ClientService {

  private final LoadBalancerClient loadBalanced;

  private final RestTemplate restTemplate;

  private final ProductClient productClient;

  @Autowired
  public ClientService(LoadBalancerClient loadBalanced,RestTemplate restTemplate,ProductClient productClient) {
    this.loadBalanced = loadBalanced;
    this.restTemplate = restTemplate;
    this.productClient = productClient;
  }

  @GetMapping("/getProductMsg")
  public String getProductMsg(){
    /**
     *     方式1：使用RestTemplate 缺点：URL写死,当部署的垂直服务较多的时候，无法负载均衡
     */
//    RestTemplate restTemplate = new RestTemplate();
//    String response = restTemplate.getForObject("http://localhost:8082/product-service/msg",String.class);
    /**
     * 方式2：使用LoadBalancerClient,获取实例的URL与host，在使用restTemplate，较为麻烦
     */
    ServiceInstance serviceInstance =loadBalanced.choose("PRODUCT");
//    String url = String.format("http://%s:%s/%s",serviceInstance.getHost(),serviceInstance.getPort(),"product-service/msg");
//    log.info("url:{}",url);
//    RestTemplate restTemplate = new RestTemplate();
//    String response = restTemplate.getForObject(url,String.class);
    /**
     * 方式3：使用配置文件将属性注入(利用注解在restTemplate中获取应用名称)
     */
    String response =restTemplate.getForObject("http://PRODUCT/product-service/msg",String.class);
    log.info("response:{}",response);
    return response;
  }

  @GetMapping("/getProductMsg-Feign")
  public String getProductMsgFeign(){
    String response = productClient.productMsg();
    log.info("response:{}",response);
    return response;
  }
}
