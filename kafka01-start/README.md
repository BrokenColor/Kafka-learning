# kafka start
### 配置信息
####　Broker Configs
+ **broker.id**：此服务器的broker id,需唯一
+ **log.dirs**：日志目录，默认地址/tmp/kafka-logs
+ **zookeeper**.connect：Zookeeper连接地址

[Broker详细配置信息](http://kafka.apache.org/20/documentation.html#brokerconfigs)

#### Topic Configs
[Topic详细配置信息](http://kafka.apache.org/20/documentation.html#topicconfigs)

####　Producer Configs
+ key.serializer：key序列化程序类
+ value.serializer：value序列化程序类
+ bootstrap.servers：用于建立与Kafka集群的初始连接的主机/端口对列表。此列表应采用形式host1:port1,host2:port2,...
+ client.id：发出请求时传递给服务器的ID字符串。其目的是通过允许在服务器端请求日志中包括逻辑应用程序名称，从而能够跟踪IP /端口以外的请求源。

[Producer详细配置信息](http://kafka.apache.org/20/documentation.html#producerconfigs)

####　Consumer Configs(kafka0.9.0.0以后的版本)
+ key.serializer：key序列化程序类
+ value.serializer：value序列化程序类
+ bootstrap.servers：用于建立与Kafka集群的初始连接的主机/端口对列表。此列表应采用形式host1:port1,host2:port2,...
+ group.id:标识此使用者所属的使用者组的唯一字符串。如果使用者使用通过使用组管理功能subscribe(topic)或基于Kafka的偏移量管理策略，则需要此属性。
+ client.id：发出请求时传递给服务器的ID字符串。其目的是通过允许在服务器端请求日志中包括逻辑应用程序名称，从而能够跟踪IP /端口以外的请求源。

[Consumer详细配置信息](http://kafka.apache.org/20/documentation.html#consumerconfigs)




