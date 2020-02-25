## Docker

### Docker介绍

Docker允许一个应用程序及其所有依赖以一种标准的单位来打包。

类比：

-  可以粗糙的理解为轻量级的虚拟机
- 开挂的chroot



### 常用命令

- Docker info：查看Docker运行信息
- Docker ps：Docker内运行的镜像
- Docker run：运行Docker镜像
- Docker stop DockerID：停止Docker镜像
- Docker rmiDockerID：删除镜像
- Docker logs -f -t --tail=20 ApplicationName：查看镜像内ApplicationName日志

![image-20200221150035439](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200221150035439.png)

![image-20200221150053014](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200221150053014.png)



### 图解

![image-20200221104723268](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200221104723268.png)

![image-20200221104737632](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200221104737632.png)


### 微服务与容器技术
- 从系统环境开始，自底向上打包应用
- 轻量级，对资源的有效隔离与管理（进程隔离，镜像管理）
- 可复用、版本化

### 水平扩展立方体
- X轴，水平扩展副本克隆（基于Docker的镜像扩容，快速实现）
- Y轴，应用解耦（利用Docker不同的应用打包成不同的镜像）

![image-20200225090253146](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/image-20200225090253146.png)







