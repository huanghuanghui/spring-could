**Spring Could Config**

- 新建model
- 勾选Spring Could Config 与 Eureka Discovery Server 
- @EnableDiscoveryClient
- 配置Eureka
- @EnableConfigServer
- 配置git仓库地址(可以使用自己的私库，GitHub较为缓慢)
- 访问 http://localhost:8760/order-dev.yml（若yml配置写错，访问会报错）
- 命名格式：/{label}/{name}-{profiles}.yml(name:服务名，profiles:环境，label:{git分支，默认master})

**命名格式**
- /{name}-{profiles}.yml || /{name}-{profiles}.properties || /{name}-{profiles}.json
- /{label}/{name}-{profiles}.yml
- name:服务名，profiles:环境，label:{git分支，默认master}

**配置client端**  
- 去除服务端配置代码，以order为例  

```xml
    <!--配置中心化-->
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-config-client</artifactId>
    </dependency>
```
- 删除原配置代码
- 将client端的application.yml修改为bootstrap.yml，优先拉取远程配置后启动

