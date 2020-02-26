package com.hhh.order.message;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * @author hhh
 * @date 2020/2/25 15:38
 * @Despriction 接受MQ消息
 */
@Log4j2
@Component
public class MqReceiver {


  /**
   * 1. @RabbitListener(queues = "myQueue")需要手动创建队列
   * 2. 自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
   * 3. 自动创建, Exchange和Queue绑定
   * （生产者指定exchange和routing key，声明队列并将队列绑定到exchange，消费者只需从生产者绑定的队列消费即可）
   */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("MqReceiver: {}", message);
    }

  /**
   * 接收product-info的消息
   * @param message
   */
  @RabbitListener(bindings = @QueueBinding(
            value = @Queue("product-info"),
            exchange = @Exchange("myExchange2")
    ))
    public void productInfo(String message) {
        log.info("收到product消息为: {}", message);
    }

    /**
     * 数码供应商服务 接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",//路由
            value = @Queue("computerOrder")
    ))
    public void processComputer(String message) {
        log.info("computer MqReceiver: {}", message);
    }


    /**
     * 水果供应商服务 接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void processFruit(String message) {
        log.info("fruit MqReceiver: {}", message);
    }
}
