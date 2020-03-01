## Spring Cloud Sleuth链路监控
- 引入依赖
```xml
   <!-- Sleuth链路监控-->
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-zipkin</artifactId>
    </dependency>
```
- docker 安装zipkin
```text
docker run -d -p 9411:9411 openzipkin/zipkin
```
- 借助zipkin生成视图，方便查看
- 配置zipkin
```yaml
#配置zipkin
spring: 
  zipkin:
    base-url: http://122.112.204.214:9411/
    #将多少比例的情求发送到外部监控的抽样百分比
  sleuth:
    sampler:
      rate: 10
```
### 分布式追踪系统（OpenTracing）
- 数据采集
- 数据存储
- 展示查询