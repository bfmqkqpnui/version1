package com.limovue.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = {"com.emp.dao", "com.limovue.dao"})
@ComponentScan(basePackages = {
        "com.limovue.controller",
        "com.limovue.service",
        "com.emp.service",
        "com.limovue.aop",
        "com.limovue.propertiesClass",
        "com.limovue.common.propertiesClass"})
@EntityScan(basePackages = {"com.limovue.domain", "com.emp.domain"})
//启注解事务管理
@EnableTransactionManagement
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
