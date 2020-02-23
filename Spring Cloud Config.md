**Spring Could Config**

- 新建model
- 勾选Spring Could Config 与 Eureka Discovery Server 
- @EnableDiscoveryClient
- 配置Eureka
- @EnableConfigServer
- 配置git仓库地址(可以使用自己的私库，GitHub较为缓慢)
- 访问 http://localhost:8760/order-dev.yml（若yml配置写错，访问会报错）
- 命名格式：/{label}/{name}-{profiles}.yml(name:服务名，profiles:环境，label:{git分支，默认master})

**使用Spring Cloud Config优势**
- 更改配置无需重启应用（Spring Could Bus 自动刷新配置）
- 可以隐藏配置中的隐私信息，例如生产数据库密码等

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

**配置中心高可用**
- 多启动几个实例即可  

**注意**
- 在Spring Cloud Config 读取git配置时，会将配置进行合并，所以可以将相同配置抽取，写到一个文件中
- 当配置的Eureka的端口不为8761时，会抛出异常，需要将Eureka的注册配置写到具体项目配置文件中
