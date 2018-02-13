package com.emp.service.activemq.impl;

import com.emp.service.activemq.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerServiceImpl implements ConsumerService {
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    /**
     * 点对点监听的队列名称
     *
     * @param text
     */
    @JmsListener(destination = "queue.member")
    @Override
    public void receiveQueue(String text) {
        logger.info("Consumer收到的报文为:" + text);
    }

    @JmsListener(destination = "topic.member")
    @Override
    public void receiveTopic(String text) {
        logger.info("消费者接收到的广播内容为:" + text);
    }
}
