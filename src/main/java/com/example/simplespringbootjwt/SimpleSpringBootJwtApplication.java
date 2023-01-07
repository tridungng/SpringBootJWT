package com.example.simplespringbootjwt;

import com.example.controller.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.example")
public class SimpleSpringBootJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSpringBootJwtApplication.class, args);
    }
}
