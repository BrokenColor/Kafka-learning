import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Author: bc
 * @DateTime: 2020/1/15 下午5:36
 * @Description: kafka 生产者demo
 */
public class ProducerFastStart {
    public static final String brokerlist = "localhost:9092";
    public static final String topic = "topic-demo";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerlist);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        //自己直生产者客户端参数并创建 Kafk aProducer 实例
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        //构建所需妥发送的消息
        ProducerRecord<String, String> records = new ProducerRecord<>(topic, "hello kafka!");
        try {
            producer.send(records);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
