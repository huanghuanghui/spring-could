## 服务网关与Zuul
**选择依赖**
- Cloud Config Client
- Eureka Discovery
- Zuul
**主类添加注解**
```java
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ApiGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiGatewayApplication.class, args);
  }
}
```
**示例**
以product项目接口：http://localhost:8082/v1/send-amqp为例，    
使用网关访问为：http://localhost:8084/product/v1/send-amqp

**注意**
- 使用Zuul Cookie 无法传递，需要配置参数
**自动更新zuul属性配置**
通过配置中心，自动注册zuul的属性
```java
/**
 * @author hhh
 * @date 2020/2/26 17:29
 * @Despriction 配置属性，自动更新zuul属性
 */
public class ZuulConfig {
  @ConfigurationProperties(prefix = "zuul")
  @RefreshScope
  public ZuulProperties zuulProperties(){
    return new ZuulProperties();
  }
}
```
