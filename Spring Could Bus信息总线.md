**Spring Could Bus**  
信息总线，使用其可以无需重启系统，自动刷新配置  
![image-20200223122302683](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200223122517717.png)

**Spring Could Bus使用**
- 引入依赖Spring Could Bus

**使用WebHook自动更新配置**
![image-20200225091130764](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200225091130764.png)

**外网映射**
- 使用https://natapp.cn 提供的免费隧道进行WebHook的外网映射
- 配置WebHooks的PayLoad为http://j3mrq9.natappfree.cc/monitor（http://j3mrq9.natappfree.cc为https://natapp.cn提供的隧道）

**Order客户端**
- 需要引入Bus依赖
```xml
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-bus-amqp</artifactId>
    </dependency>
```
- 配置对应MQ
- 需要更新配置的位置加上@RefreshScope注解,比如order下的`ProjectProperties`（**大坑**）
- 有可能申请的隧道会失效(http://7s4rcv.natappfree.cc/monitor)，可以使用（http://localhost:8760/actuator/bus-refresh）刷新配置（**坑**）
