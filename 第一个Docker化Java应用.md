## 第一个Docker化Java应用

### 1、Docker介绍

Docker是一个用来装应用的容器，就像杯子可以装水，笔筒可以放笔，你可以将Hello World、网站放到Docker中，可以将任何想得到的程序放到Docker中。

```text
Debug your app, not your environment
```

### 2、Docker思想

- 集装箱（保证我们的程序不管运行在哪，不会缺东西）
- 标准化
  - 运输方式
  - 存储方式
  - API接口
- 隔离

### 3、Docker的出现解决问题

场景描述

- 我本地环境没有问题啊！
- 系统好卡，谁的程序又写死循环了！
- 双十一来了！系统撑不住了！

解决问题：

- 运行环境不一致（集装箱）

- 共用服务器时互不影响（隔离性）

- 快速扩展，弹性伸缩（标准性）

### 4、走进Docker

- 镜像（集装箱）（Build）
- 仓库（超级码头）（Ship）
- 容器（运行程序的地方）（Run）

**Docker运行一个程序的过程：去仓库，把镜像拉到本地，然后用一条命令将程序运行起来，变成容器。**

#### 4.1 Docker镜像（Image）

鲸鱼驮着的所有集装箱，就是一个镜像，本质上说，镜像就是一系列的文件

![image-20200301130705976](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200301130705976.png)

#### 4.2 Docker容器

容器的本质就是一个进程（虚拟机，每一个虚拟机都有自己的文件系统），一个镜像可以生成多个容器，独立运行，他们之间没有任何干扰。

#### 4.3 Docker仓库

构建镜像的目的是，在其他的环境或其他机器上运行程序。想在其他环境运行，需要将本地镜像传到目的地去，如何传输镜像，便用到了Docker仓库。

传输过程：

- 将镜像传到Docker仓库
  - 仓库由Docker提供，地址：hub.docker.com（慢）
  - 国内仓库：c.163.com
- 由目的地将Docker镜像拉取

![image-20200301131155773](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200301131155773.png)

### 5、Docker Centos安装

 http://www.imooc.com/article/16448 

### 6、第一个Docker镜像

- docker pull [options] NAME[:tags] ：拉取docker镜像
- docker images[options] [repository [:tags] ] ：查看本机所有镜像
- docker run [options] images [:tags] [command] [args]

```bash
[huanghh@127 ~]$ docker pull hello-world
[huanghh@127 ~]$ docker images
[huanghh@127 ~]$ docker run hello-world
```

![image-20200301140055329](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200301140055329.png)

### 7、Docker运行Nginx服务

#### 7.1 Nginx镜像

- 持久运行的容器
- 前台挂起&后台运行
  - 前台启动：docker run
  - 后台启动：docker run -d
  - 如果不清楚参数的话可以使用，docker --help 查看具体参数
- 进入容器内部
  - docker exec -it imageId bash，可以想操作Linux系统一样操作容器，exit退出

步骤

- 进入 https://c.163.com/hub#
- 搜索Nginx
- 进入有鲸鱼图标的Nginx，右边的下载地址进行下载（docker pull 拉取镜像）

#### 7.2 Docker 网络

- 网络类型
  - Bright 		Host 		None
- 端口映射（宿主机与容器端口映射）

- docker run -d -p 8080:80 容器ID
  - -d：后台启动
  - -p：端口映射 宿主机端口:容器端口
- **docker run -d -P 容器ID：端口随机映射，在不知道镜像需要暴露的端口的时候推荐使用，可以不用指定端口，不会映射错误**

### 8、Docker化的Java web

- DockerFile：用来告诉Docker我要如何制作镜像

- DockerBuild： 用来执行DockerFile描述的每一件事，最终构建镜像

