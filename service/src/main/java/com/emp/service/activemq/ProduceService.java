package com.emp.service.activemq;


import com.limovue.common.myEnum.MQSendType;

import javax.jms.Destination;

/**
 * 消息队列生产者
 */
public interface ProduceService {

    /**
     * 发送消息，destination是发送到的队列，message是待发送的消息
     * @param sendTypeName
     * @param message
     */
    void sendMessage(String sendTypeName, String message,MQSendType type);
}
