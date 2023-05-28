package com.lfz.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@MapperScan("com.lfz.demo.mapper")
public class BillManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillManagerApplication.class, args);
    }

}
