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
- 更改配置无需重启应用（Spring Could Bus 消息中线/自动刷新配置）
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
