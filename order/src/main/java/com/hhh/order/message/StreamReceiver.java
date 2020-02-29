package com.hhh.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author hhh
 * @date 2020/2/25 15:38
 * @description Spring Cloud Stream：消息中间件 接受MQ消息
 */
@Component
@EnableBinding(StreamOutput.class)
@Slf4j
public class StreamReceiver {

  /**
   * 监听myMessage
   *
   * @param message
   */
  @StreamListener(value = StreamInput.INPUT)
  @SendTo(StreamInput.INPUT2)
  public String process(Object message) {
    log.info("StreamReceiver: {}", message);
    //@SendTo(StreamClient.INPUT2) 发送给myMessage2的消息
    return "Message：myMessage消费成功，通知myMessage2";
  }
//
//  /**
//   * 验证 @SendTo(StreamClient.INPUT2)消息是否有发回给myMessage2
//   *
//   * @param message
//   */
//  @StreamListener(value = StreamInput.INPUT2)
//  public void process2(Object message) {
//    log.info("Product 消费成功后处理: {}", message);
//  }
}
