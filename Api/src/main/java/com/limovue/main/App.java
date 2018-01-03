package com.limovue.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan(basePackages={"com.limovue.controller","com.limovue.service"})
@EnableJpaRepositories(basePackages = {"com.limovue.dao"})
@EntityScan(basePackages = {"com.limovue.domain"})
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
