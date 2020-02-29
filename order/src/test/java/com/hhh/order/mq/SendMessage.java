package com.hhh.order.mq;

import com.hhh.order.SuperTest;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author hhh
 * @date 2020/2/25 16:44
 * @description 发送MQ消息测试
 */
public class SendMessage extends SuperTest {
  @Autowired
  private AmqpTemplate amqpTemplate;

  /**
   * 正常发送消息
   */
  @Test
  public void sendMessage(){
    amqpTemplate.convertAndSend("myQueue",new Date());
  }

  /**
   * 发送带exchange消息
   */
  @Test
  public void send(){
    amqpTemplate.convertAndSend("myOrder","computer",new Date());
  }
}
