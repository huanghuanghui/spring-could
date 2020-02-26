package com.hhh.product.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhh
 * @date 2020/2/26 15:28
 * @Despriction
 */
@RestController
@RequestMapping("/v1")
public class SendMessageController {

  private final AmqpTemplate amqpTemplate;

  @Autowired
  public SendMessageController(AmqpTemplate amqpTemplate) {
    this.amqpTemplate = amqpTemplate;
  }

  @GetMapping("/send-amqp")
  public String sendAmqp(){
    //product-info为队列名称，需要创建
    amqpTemplate.convertAndSend("product-info","product发送消息");
    return "product发送消息";
  }

}
