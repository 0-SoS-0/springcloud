package cn.itcast.order.mapper;

import cn.itcast.order.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    Order findById(@Param("orderId") Long orderId);
}
