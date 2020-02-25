## RabbitMQ与SpringCould整合遇到问题
详情见:https://www.cnblogs.com/huanghuanghui/p/12361887.html  
```text
PLAIN login refused: user 'admin' - invalid credentials
```
 

Docker中安装RabbitMQ后，访问15672控制台正常访问，应用启动后报错
```text
Failed to create consumer binding; retrying in 30 seconds

org.springframework.cloud.stream.binder.BinderException: Exception thrown while starting consumer: 
与
An unexpected connection driver error occured

java.net.SocketException: socket closed
```
使用docker logs -f rabbitmq3.7.7查看 Docker日志，发现报错

```text
PLAIN login refused: user 'admin' - invalid credentials
```
无权限访问，添加用户， 并设置权限

设置Virtual Hosts

配置用户权限

删除my_vhost权限，后应用正常

访问http://localhost:8760/actuator/bus-refresh，mq正常



