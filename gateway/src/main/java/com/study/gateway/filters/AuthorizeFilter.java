package com.study.gateway.filters;

import org.apache.http.HttpStatus;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

/**
 * 网关自定义过滤器
 */
//@Order(-1)         //执行顺序，值越小优先级越高
@Component
public class AuthorizeFilter implements GlobalFilter, Order {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1、获取请求参数
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        //2、判断是否含有 authorizeation
        String authorizeation = queryParams.getFirst("authorizeation");
        //3、判断
        if (StringUtils.pathEquals("admin", authorizeation)) {
            //符合条件的放行
            return chain.filter(exchange);
        }
        exchange.getResponse().setRawStatusCode(HttpStatus.SC_UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }


    /**
     * 注解或者实现方法都可以
     * 执行顺序，值越小优先级越高
     *
     * @return
     */
    @Override
    public int value() {
        return -1;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
