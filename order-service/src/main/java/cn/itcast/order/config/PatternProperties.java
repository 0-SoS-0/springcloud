package cn.itcast.order.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component

/**
 * nacos配置热更新的两种方式
 * 1、在获取配置内容的类上使用@RefreshSocpe注解
 * 2、创建配置类，使用@ConfigurationProperties注解该类
 */
@ConfigurationProperties(prefix = "pattern")
@Data
public class PatternProperties {
    private String dateformat;
    private String common;
}
