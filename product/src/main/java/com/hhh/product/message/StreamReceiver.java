package com.hhh.product.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author hhh
 * @date 2020/2/25 15:38
 * @Despriction Spring Cloud Stream：消息中间件 接受MQ消息
 */
@Component
@EnableBinding(StreamInput.class)
@Slf4j
public class StreamReceiver {


  /**
   * 验证 @SendTo(StreamClient.INPUT2)消息是否有发回给myMessage2
   *
   * @param message
   */
  @StreamListener(value = StreamInput.INPUT2)
  public void process2(Object message) {
    log.info("Product消费成功后处理: {}", message);
  }
}
