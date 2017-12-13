package com.tikie.jms.activemq.spring.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TiKie
 * @desc
 * @date 2017/12/13
 */
public class AppConsumer {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");

    }
}
