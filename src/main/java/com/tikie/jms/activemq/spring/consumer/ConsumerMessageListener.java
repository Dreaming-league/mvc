package com.tikie.jms.activemq.spring.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author TiKie
 * @desc
 * @date 2017/12/13
 */
public class ConsumerMessageListener implements MessageListener{
    /**
     * Passes a message to the listener.
     *
     * @param message the message passed to the listener
     */
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("接收消息："+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
