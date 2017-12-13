package com.tikie.jms.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author TiKie
 * @desc 主题模式的消费者，需要先监听（启动），生产者生产后才能收到，可以收到（订阅）所有内容
 * @date 2017/12/13
 */
public class AppConsumer {
    public static final String url = "tcp://39.106.19.98:61616";
    public static final String queueName = "topic-test";

    public static void main(String[] args) throws JMSException {
        // 1.创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        // 2.创建连接
        Connection connection = connectionFactory.createConnection();

        // 3.启动连接
        connection.start();

        // 4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 5.指定目标
        Destination destination = session.createTopic(queueName);

        // 6.创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        // 7.创建监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收消息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
