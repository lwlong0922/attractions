package com.database.attractions.config;

import com.database.attractions.tool.BeanUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public BeanUtil createRunableFactory(){
        return new BeanUtil();
    }
}
