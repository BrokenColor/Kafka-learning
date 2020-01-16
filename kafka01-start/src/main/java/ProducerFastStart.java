import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Author: bc
 * @DateTime: 2020/1/15 下午5:36
 * @Description: kafka Producer Demo
 */
public class ProducerFastStart {
    public static final String brokerList = "localhost:9092";
    public static final String topic = "topic-demo";

    public static void main(String[] args) {
        Properties properties = new Properties();
        //kafka服务地址，多个地址可用逗号隔开
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        //key序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        //key序列化
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        //自己直生产者客户端参数并创建KafkaProducer 实例
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        //构建需要发送的消息
        ProducerRecord<String, String> records = new ProducerRecord<>(topic,"key" ,"hello world");
        try {
            //发送消息
            producer.send(records);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭生产者客户端
            producer.close();
        }
    }
}
