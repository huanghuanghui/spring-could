## 客户端负载均衡器Ribbon

#### Ribbon封装

- RestTemplate
- Feign
- Zuul

#### Ribbon作用

软负载均衡

- 服务发现：发现依赖服务列表，找到服务实例
- 服务选择规则：从多个服务选择有效服务
- 服务监听：检测失效服务，做到高效剔除

#### Ribbon主要组件

- ServerList
- IRule
- ServerListFilter

#### 查看Ribbon源码

- 获取服务列表：`BaseLoadBalancer.getAllServers()`

```text
    public List<Server> getAllServers() {
        return Collections.unmodifiableList(this.allServerList);
    }
```

- 负载均衡：默认负载均衡模式为轮询（RoundRobinRule，一般无需改变）
  - `BaseLoadBalancer`
  - `DynamicServerListLoadBalancer`
  - `ZoneAwareLoadBalancer`
  - ...

#### 自定义配置负载均衡

Ribbon负载均衡种类：查看`IRule`接口的实现即可

```text
PRODUCT:
  ribbon: 
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
```

