package com.hhh.product.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @author hhh
 * @date 2020/2/25 15:38
 * @description Spring Cloud Stream 消息中间件消息发送与接收
 */
@Component
public interface StreamInput {

  String INPUT = "myMessage";

  @Input(StreamInput.INPUT)
  SubscribableChannel input();


  /**
   * myMessage 收到消息时，回给myMessage2一条消息，告诉myMessage消费成功
   */
  String INPUT2 = "myMessage2";

  @Input(StreamInput.INPUT2)
  SubscribableChannel input2();
}
