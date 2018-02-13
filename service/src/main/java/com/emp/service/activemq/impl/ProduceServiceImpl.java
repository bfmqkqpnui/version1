package com.emp.service.activemq.impl;

import com.emp.service.activemq.ProduceService;
import com.limovue.common.myEnum.MQSendType;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;


@Component
public class ProduceServiceImpl implements ProduceService {
    // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    /**
     * 发送消息
     * activeMQQueueName是队列名
     * message是待发送的消息
     * type QUEUE是队列，TOPIC是广播
     *
     * @param activeMQQueueName
     * @param message
     */
    @Override
    public void sendMessage(String activeMQQueueName, String message, MQSendType type) {
        Destination destination = null;
        switch (type) {
            case QUEUE:
                if (StringUtils.isNotBlank(activeMQQueueName)) {
                    destination = new ActiveMQQueue(activeMQQueueName);
                } else {
                    destination = new ActiveMQQueue("queue.member");
                }
                break;
            case TOPIC:
                if (StringUtils.isNotBlank(activeMQQueueName)) {
                    destination = new ActiveMQTopic(activeMQQueueName);
                } else {
                    destination = new ActiveMQTopic("topic.member");
                }
                break;
        }
        jmsTemplate.convertAndSend(destination, message);
    }
}
