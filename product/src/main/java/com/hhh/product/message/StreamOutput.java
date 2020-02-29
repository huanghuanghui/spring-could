package com.hhh.product.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author hhh
 * @date 2020/2/26 15:06
 * @description
 */
@Component
public interface StreamOutput {

  @Output(StreamInput.INPUT)
  MessageChannel output();

  /**
   * myMessage 收到消息时，回给myMessage2一条消息，告诉myMessage消费成功
   */
  @Output(StreamInput.INPUT2)
  MessageChannel output2();
}
