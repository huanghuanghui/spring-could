**Queue与Exchange**
![Queue与Exchange](http://jn-hhh.oss-cn-hangzhou.aliyuncs.com/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200225165426.png)

- 如上图，当服务越来越大，订单服务可以发送数码供应商或水果供应商的消息
- 订单根据不同的商品类型发送不同的MQ消息数码供应商只关心数码供应商消息
- Queue与Exchange可以对消息进行分组
