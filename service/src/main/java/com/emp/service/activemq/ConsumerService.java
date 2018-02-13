package com.emp.service.activemq;

public interface ConsumerService {
    /**
     * 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
     *
     * @param text
     */
    void receiveQueue(String text);

    /**
     * 使用JmsListener配置消费者监听的广播，其中text是接收到的消息
     *
     * @param text
     */
    void receiveTopic(String text);
}
