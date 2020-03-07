package conf;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @Author: bc
 * @DateTime: 2020/1/17 上午11:19
 * @Description: 配置文件
 */
public class PropertiesConfig {
    private static Properties prop;
    private static String bootstrap_servers="";
    PropertiesConfig(){
        prop = new Properties();
    }
    public static Properties init(){
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrap_servers);
        prop.put(ProducerConfig.RETRIES_CONFIG,10);//重试次数
        return prop;
    }
}
