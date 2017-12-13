package com.tikie.jms.activemq.spring.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * @author TiKie
 * @desc
 * @date 2017/12/13
 */
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    JmsTemplate jmsTemplate;

    @Resource(name = "topicDestination")// 队列模式为queueDestination
    Destination destination;
    public void sendMessage(final String message) {
        // 使用jmsTemplate发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            // 创建一个消息
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
        System.out.println("发送消息："+message);
    }
}
