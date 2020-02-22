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
