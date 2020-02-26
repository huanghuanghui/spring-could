## Spring Boot starter amqp
使用Spring Boot starter amqp收发消息（本案例使用RabbitMQ）
**Queue与Exchange**
![Queue与Exchange](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200225165426.png)

- 如上图，当服务越来越大，订单服务可以发送数码供应商或水果供应商的消息
- 订单根据不同的商品类型发送不同的MQ消息数码供应商只关心数码供应商消息
- Queue与Exchange可以对消息进行分组


**只让一个实例接收到消息**
- 添加分组
```text
spring:
  cloud:
    stream: 
      bindings:
        myMessage:      #本项目消息名称
          group: order    #随便取
```
- 配置MQ消息为JSON（MQ控制台getMessage查看消息，查看到的为base64编码后字符串，改为JSON可以在消息堆积时，查看消息具体内容） 
```text
# 让配置先启动
server:
  port: 8083
#配置应用名称
spring:
  cloud:
    stream:
      bindings:
        myMessage:
          content-type: application/json
```
- 不同系统之间收发消息
- 生产方
```java
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
```
- 消费方
```java
@Log4j2
@Component
public class MqReceiver {
  /**
   * 自动创建, Exchange和Queue绑定
   * （生产者指定exchange和routing key，声明队列并将队列绑定到exchange，消费者只需从生产者绑定的队列消费即可）
   */
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
}
```
###扣库存操作
若需要扣库存的为一个集合，需要将消息封装为集合发送，不然当订单抛出异常，  
数据回滚，会导致数据不一致。
