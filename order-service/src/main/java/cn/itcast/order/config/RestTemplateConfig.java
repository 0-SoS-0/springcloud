package cn.itcast.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class RestTemplateConfig {


    /**
     * 提供了Java内的HTTP请求
     * eureka注册中心服务发现：
     * 1、给RestTemplate加@LoadBalanced注解
     * 2、用服务提供者的服务名称远程调用
     *
     * @return
     */
    @Bean
    @LoadBalanced   //服务服务负载均衡（集群模式下）
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
