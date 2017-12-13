package com.tikie.jms.activemq.spring.producer;

/**
 * @author TiKie
 * @desc
 * @date 2017/12/13
 */
public interface ProducerService {
    void sendMessage(String message);
}
