package com.database.attractions;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.database.attractions.mapper")
@SpringBootApplication
public class AttractionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttractionsApplication.class, args);
    }

}
