package com.tikie.jms.activemq.spring.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TiKie
 * @desc
 * @date 2017/12/13
 */
public class AppProducer {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service = context.getBean(ProducerService.class);
        for (int i = 0; i < 100; i++) {
            service.sendMessage("test"+i);
        }

        context.close();
    }
}
