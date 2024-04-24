package com.example.libserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.libserver.mapper")
public class LibServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibServerApplication.class, args);
    }
}
