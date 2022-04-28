package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import com.example.feignapi.feign.UserFeignClient;
import com.example.feignapi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;


    /**
     * 当FeignClient不在SpringBootApplication扫描范围内的解决方案
     * 1、指定FeignClient所在包————@EnableFeignClients("package:com.example.feignapi.feign")
     * 1.1、指定FeignClient字节码————@EnableFeignClients("clients={FeignClient.class}")
     *
     */
    @Autowired
    private UserFeignClient feignClient;

    /* 使用feign 发起请求
    @Autowired
    private RestTemplate restTemplate;
*/
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        //2、RestTemplate发起HTTP请求
        //2.1先获取url路径
        //String url = "http://localhost:8111/user/" + order.getUserId();
 /*       String url = "http://userserver/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);*/

        User user = feignClient.getUserInfoById(order.getUserId());
        order.setUser(user);
        // 4.返回
        return order;
    }
}
