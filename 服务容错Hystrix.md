## 服务容错Hystrix
![image-20200229144739109](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200229144739109.png)
### Spring Cloud Hystrix
- 防雪崩利器 
- 基于NetFlix对应的Hystrix
### 服务降级
- 优先核心服务，非核心服务不可用或弱可用
- 通过HystrixCommand 注解指定
- fallbackMethod（回退函数）中具体实现降级逻辑

### 使用
- 添加依赖
```xml
            <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
            </dependency>
```
- 添加注解@EnableCircuitBreaker

### 依赖隔离
- 线程池隔离
- Hystrix自动实现了依赖隔离
### 服务熔断
```text
    @HystrixCommand(commandProperties = {
            //服务熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                //设置熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),    //错误率
    })
```
### 写入配置文件
可以通过配置文件的方式配置服务熔断与降级，配置后只需在方法上打上@HystrixCommand注解即可
### Hystrix可视化
- 引入依赖
```xml
   <!-- 对Hystrix 进行实时监控的工具-->
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
    </dependency>
```
- 打上注解@EnableHystrixDashboard
- 访问http://127.0.0.1:8083/hystrix
- 监控order断路情况
![image-20200229162515329](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200229162515329.png)

### Zuul超时设置
Zuul依赖了Hystrix，可以使用配置文件配置的方式配置Zuul的超时时间