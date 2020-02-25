## Spring Cloud Stream：消息中间件
![Spring Cloud Stream：消息中间件](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200225170435098.png)
- 对消息容器的抽象，不同的消息容器有不同的实现，通过它可以屏蔽各消息容器的内部细节。
- 简化分布式开发
- 简化开发人员对消息中间件使用的复杂度，开发人员可以更专注于业务
## 使用
- 添加依赖
```xml
    <!--使用Stream RabbitMQ-->
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
    </dependency>
```
