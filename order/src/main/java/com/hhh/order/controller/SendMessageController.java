package com.hhh.order.controller;

import com.hhh.order.dto.OrderDTO;
import com.hhh.order.message.StreamOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author hhh
 * @date 2020/2/18 16:43
 * @Despriction 测试发送消息
 */
@RestController
@RequestMapping("/v1")
public class SendMessageController {

  private final StreamOutput streamOutput;

  @Autowired
  public SendMessageController(StreamOutput streamOutput) {
    this.streamOutput = streamOutput;
  }

  @GetMapping("/send-string")
  public void process() {
    String message = "now " + new Date();
    streamOutput.output().send(MessageBuilder.withPayload(message).build());
  }

  /**
   * 发送 orderDTO对象
   */
  @GetMapping("/send-dto")
  public void process1() {
    OrderDTO orderDTO = new OrderDTO();
    orderDTO.setOrderId("123456");
    streamOutput.output().send(MessageBuilder.withPayload(orderDTO).build());
  }
}
