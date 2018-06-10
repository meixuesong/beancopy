package cn.meixs;

import cn.meixs.beancopy.domain.Order;
import cn.meixs.cn.beancopy.repository.OrderJpa;

public interface OrderMapper {
    OrderJpa fromOrder(Order order);
}
