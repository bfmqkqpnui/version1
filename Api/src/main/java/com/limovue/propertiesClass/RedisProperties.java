package com.limovue.propertiesClass;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "spring-redis")
public class RedisProperties {
    /**
     * redis服务器
     */
    private String host;
    /**
     * redis端口号
     */
    private int port;
    /**
     * redis服务器密码
     */
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
