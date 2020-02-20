## Eureka注册中心

### 微服务

- 将大型系统拆分成微小的服务
- 运作在自己的进程之中
- 每个服务为独立的业务开发
- 独立部署
- 分布式管理

### 分布式定义

旨在支持应用程序和服务的开发，可以利用物理架构，由多个自治的处理元素（多节点），不共享主内存，但通过网络发送**消息**合作。

​																													--Leslie Lamport

### 项目创建

- 选择创建spring项目，勾选dependency eureka service

- 配置需要的application.yml @EnableEurekaService 打开eureka注册中心

### Eureka高可用

![image-20200214105406811](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200214105406811.png)

- 采用多个Eureka互相注册的模式，开启多个eureka注册中心服务
- 例如：A与B 2台eureka注册中心，A port 8761，B port 8762，服务注册到A中，再将A与B互相注册(垂直架构，多port部署多注册中心)
- 如果eureka A挂掉之后，我们需要联通服务的同时还需要重启client，我就就需要在client中注册多个eureka的服务地址，来保证服务高可用

```yml
#多个注册中心互相注册保证eureka服务高可用
Eureka-A -port 8761 defaultZone: http://127.0.0.1:8762/eureka
Eureka-B -port 8762 defaultZone: http://127.0.0.1:8761/eureka
#client往多eureka中进行注册，保证Eureka-A挂掉以后自动注册进Eureka-B
eureka:
  client:
    service-url:
      defaultZone: http://127.0.0.1:8761/eureka,http://127.0.0.1:8762/eureka
```



![image-20200214103601041](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200214103601041.png)

3个Eureka注册中心：

![image-20200214105050231](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200214105050231.png)

```yml
#两两注册
eureka:
  client:
    service-url:
      defaultZone: http://127.0.0.1:8761/eureka,http://127.0.0.1:8762/eureka
```

### 服务注册

- 注册中心，负责服务的注册于发现，沟通前后端

- 服务治理

- 服务发现（客户端发现与服务端发现）
  - 客户端发现：Eureka
  - 服务端发现：Zookeeper、Nginx、Kubernetes

- 负载均衡（Random LoadBalance/Constisant LoadBalance ..）

### 微服务特点

- 异构
  - 不同语言
  - 不同类型数据库
- Spring Could 的服务调用方式为REST，Eureka提供将不同语言纳入服务自理体系中，只需要实现Eureka的客户端程序
- 前端可以使用Node.js的eureka-js-client进行服务发现

### Eureka小结

- @EnableEurekaServer @EnableEurekaClient @EnableDiscoveryClient
- 心跳检测、健康检查，负载均衡（如果某个服务流量增加只需要增加对应服务的实例即可）
- Eureka的高可用，生产至少配置2台以上
- 分布式系统中，服务注册中心是最重要的基础部分