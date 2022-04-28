package cn.itcast.order;

import com.example.feignapi.feign.UserFeignClient;
import com.example.feignapi.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//开启基于feign功能的注解
@EnableFeignClients(clients = {UserFeignClient.class})                 //解决FeignClient文件不在启动类下
@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}