import conf.PropertiesConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

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

        //send方法并非void类型
        ProducerRecord producerRecord = new ProducerRecord<>("topic-demo", "key-value");
        try {
            //在执行了send方法后直接调用get()方法来阻塞等待kafka的响应，知道消息发送成功
            producer.send(producerRecord).get();

            //也可在在执行了send方法后不直接调用get()方法
            Future<RecordMetadata> future = producer.send(producerRecord);
            RecordMetadata recordMetadata = future.get();
            System.out.println(recordMetadata.topic() + "-" + recordMetadata.partition() + "-" + recordMetadata.offset());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
