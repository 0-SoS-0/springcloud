package com.example.feignapi.feign;

import com.example.feignapi.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ————Feign的使用步骤（Feign内部实现Ribbon的负载均衡机制）
 * 1、引入依赖
 * 2、创建接口类，在类上注解@FeignClient("微服务名")
 * 3、编写FeignClient客户端，需要一个 @GetMapping注解的方法，即微服务名加上该注解方法可以实现跨服务调用（声明式的Http客户端）
 * 4、在服务启动类上添加@EnableFeignClients
 * <p>
 * ————Feign的最佳实现有两种
 * 1、给服务提供者（FeignClient）和调用者（Controller）提供继承接口，但是注解参数继承不了，需要在调用者（Controller）重新标注
 * 2、抽取成公共接口模块，像该模块一样的方式
 * 2.1其他模块直接使用该接口模块
 * <p>
 * <p>
 * 需要标注调用的服务注册名
 */
@FeignClient("userservice")
public interface UserFeignClient {

    /**
     * Feign (声明式的HTTP客户端)使用步骤
     * 1、先引入依赖
     * 2、在启动类开启基于Feign功能的注解
     * 3、编写Feign客户端
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    User getUserInfoById(@PathVariable("id") long id);
}
