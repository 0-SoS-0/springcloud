package com.example.feignapi.feign.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Feign的自定义配置（一般只配置日志级别）
 * 1、按照该类使用方式
 * 2、在配置文件配置
 */
@Configuration
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level loggerLevel() {
        return Logger.Level.BASIC;
    }
}
