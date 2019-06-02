package com.example.flowsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * mongodb windows cmd启动命令：mongod --dbpath D:\database\mongodb\data
 */
@ComponentScan({"springfox", "com.example.flowsystem"})
@MapperScan(basePackages = "com.example.flowsystem.*.dao.mapper")
@SpringBootApplication
public class FlowsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowsystemApplication.class, args);
    }
}
