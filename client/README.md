微服务client
- 创建新项目-选择dependency spring could Discovery-Eureka Discovery Service
- 添加spring-boot-starter-web、spring-cloud-starter-config dependency
- 配置application.yml中的注册中心地址
- 添加@EnableDiscoveryClient 注解，开启eureka(别加错)
