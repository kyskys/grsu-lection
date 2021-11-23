package grsu.lection.jms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;


//@Configuration
@EnableJms
public class JmsConfig {

    @Value("${jms.queue.url}")
    private String queueUrl;

    @Value("${jms.queue.topic}")
    private String topic;

//    @Bean
//    public ConnectionFactory createJmsConnectionFactory() {
//        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
//        factory.setBrokerURL(queueUrl);
//        return factory;
//    }
//
//    @Bean
//    public CachingConnectionFactory createJmsCachingConnectionFactory() {
//        CachingConnectionFactory cachingFactory = new CachingConnectionFactory(createJmsConnectionFactory());
//        cachingFactory.setSessionCacheSize(10);
//        return cachingFactory;
//    }
//
//    @Bean
//    public Destination createDestination() {
//        return new ActiveMQQueue(topic);
//    }
//
//    @Bean
//    public JmsTemplate createJmsTemplate() {
//        JmsTemplate template = new JmsTemplate(createJmsCachingConnectionFactory());
//        template.setDefaultDestination(createDestination());
//        return template;
//    }
}
