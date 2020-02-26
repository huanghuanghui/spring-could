## 服务网关与Zuul
### 服务网关要素
高可用与稳定性、性能与并发、安全性、扩展性  
**常用方案**
- Nginx+Lua
- Kong（源于Nginx+Lua）
- Tyk
- Spring Cloud Zuul（基于JVM路由与服务端负载均衡器，提供认证、限流、动态路由等）
### Zuul特点
- 路由+过滤器=Zuul
- 核心是一系列过滤器
### Zuul过滤器API
- 前置(Pre)：限流、鉴权、参数校验、情求转发
- 后置(Post)：统计、日志
- 路由(Route)
- 错误(Error)
### Zuul高可用
- 当成普通的微服务注册到Eureka Server，实现Zuul的服务高可用
- Nginx与Zuul混搭

![image-20200226155804737](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200226155804737.png)

![image-20200226155819342](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200226155819342.png)



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
