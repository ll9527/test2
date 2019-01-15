package com.totalshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.serviceImp","com.controller"})
@MapperScan("com.dao")
public class TotalshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(TotalshopApplication.class, args);
    }

}

