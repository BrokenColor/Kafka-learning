import conf.PropertiesConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Author: bc
 * @DateTime: 2020/1/17 上午11:26
 * @Description: producer demo
 */
public class ProducerDemo {
    public static void main(String[] args) {
        Properties properties = PropertiesConfig.init();
        KafkaProducer producer = new KafkaProducer(properties);
        //发消息的几种方式
        producer.send(new ProducerRecord<>("topic-demo", "value1"));
        producer.send(new ProducerRecord<>("topic-demo","key","key-value"));
        producer.send(new ProducerRecord<>("topic-demo",1,"key","key-value"));
        producer.send(new ProducerRecord<>("topic-demo",1,"key","key-value"));
    }
}
