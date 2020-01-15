# Kafka-leaning
## kafka介绍
  [Kafka](http://kafka.apache.org/) 起初是由 Linkedin 公司采用 Scala 语言开发的 个多分区、多副本且基于 ZooKeeper协调的分布式消息系统，现己被捐献给 Apache 基金会 目前 Kafka 已经定位为一个分布式流式处理平台，它以高吞吐、可持久化、可水平扩展、支持流数据处理等多种特性而被广泛使用。Kafka 起初是由 Linkedin 公司采用 Scala 语言开发的 个多分区、多副本且基于 ZooKeeper 协调的分布式消息系统，现己被捐献给 Apache 基金会 目前 Kafka 已经定位为一个分布式流式处理平台，它以高吞吐、可持久化、可水平扩展、支持流数据处理等多种特性而被广泛使用。
   - **消息系统**：kafka和传统的消息系统（也称作消息中间件〉都具备*系统解耦*、_冗余存储_、_流量峰_、_缓冲_、_异步通信_、_扩展性_、*可恢复性*等功能。与此同时， Kafka供了大多数消息系统难以实现的消息 序性保障及回溯消费的功能
   - **存储系统**：Kafka把消息持久化到磁盘，相比于其他基于内存存储的系统而言，有效地降低了数据丢失的风险 也正是得益于 Kafka 的消息持久化功能和多副本机制，我们可以把 Kafka 作为长期的数据存储系统来使用，只需要把对应的数据保留策略设置为“永久”或启用主题的日志压缩功能即可
   - **流式处理平台**：Kafka不仅为每个流行的流式处理框架提供了可靠的数据来源，还供了一个完整的流式处理类库，比如窗口、连接、变换和聚合等各类操作
## kafka体系结构
![kafka体系结构](https://github.com/BrokenColor/Kafka-learning/blob/master/files/kafka%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84.jpg)
##### kafak中的术语
+  **Producer**(生产者)：发送消息的一方。生产者负责创建消息然后将其投递到Kafka中
+  **Consumer**(消费者)：接收消息的一方。消费者连接到 Kafka 上并接收消息，进而进行相应的业务逻辑处理
+  **Broker**(服务代理节点)：对于Kafka而言，Broke可以简单地看作一个独立的 Kafka服务节点或Kafka服务实例。大多数情况下也可以将Broker看作一台Kafka服务器，前提是这台服务器上只部署了一个Kafka实例。一个或多个Broker组成了一个Kafka集群。一般而言，我们更习惯使用首字母小写的 broker 来表示服务代理节点
+  **Topic**(主题)：Kafka中的消息以主题为单位进行归类，生产者负责将消息发送到特定的主题（发送到Kafka集群中的每一条消息都要指定一个主题），而消费者负责订阅主题并进行消费。
+  **Partition**(分区)：主题可以细分为多个分区，一个分区只属于单个主题，分区在存储层面可以看作一个可追加的日志（ Log ）文件。
+  **offset**(偏移量)：消息在被追加到分区日志、文件的时候都会分配一个特定的偏移量（ offset ）。 offset 是消息在分区中的唯一标识， Kafka 通过它来保证消息在分区内的顺序性，不过 offset 并不跨越分区，也就是说， Kafka 保证的是分区有序而不是主题有序。
+  
+  
##### 多副本架构
![kafka多副本架构](https://github.com/BrokenColor/Kafka-learning/blob/master/files/%E5%A4%9A%E5%89%AF%E6%9C%AC%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84.jpg) 