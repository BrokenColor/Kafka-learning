import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @Author: bc
 * @DateTime: 2020/1/16 上午9:55
 * @Description: kafka Consumer demo
 */
public class ConsumerFastStart {
    public final static String brokerList = "localhost:9092";
    public final static String topic = "topic-demo";
    public final static String groupID = "group-test";

    public static void main(String[] args) {
        Properties properties = new Properties();
        //kafka服务地址，多个地址可用逗号隔开
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        //key反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        //value反序列化
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        //设置消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupID);
        //创建一个消费者客户端实例
        KafkaConsumer<String, String> consumer = new KafkaConsumer(properties);
        //订阅主题
        consumer.subscribe(Collections.singletonList(topic));
        //循环消费数据
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("time:" + record.timestamp() + " topic:" + record.topic() +
                        " key:" + record.key() + " value:" + record.value());
            }
        }
    }
}
