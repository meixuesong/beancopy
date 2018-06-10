package cn.meixs;

import cn.meixs.beancopy.domain.Order;
import cn.meixs.beancopy.domain.OrderItem;
import cn.meixs.beancopy.repository.CustomerJpa;
import cn.meixs.beancopy.repository.OrderItemJpa;
import cn.meixs.beancopy.repository.OrderJpa;
import cn.meixs.beancopy.repository.PhoneJpa;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderMapperPropertUtils implements OrderMapper {
    @Override
    public OrderJpa fromOrder(Order order) {
        OrderJpa orderCopied = new OrderJpa();
        try {
            PropertyUtils.copyProperties(orderCopied, order);
            PropertyUtils.copyProperties(order.getDeliverAddress(), orderCopied);
            CustomerJpa customer = new CustomerJpa();
            PropertyUtils.copyProperties(order.getCustomer(), customer);
            PhoneJpa phone = new PhoneJpa();
            PropertyUtils.copyProperties(order.getPhone(), phone);

            orderCopied.setCustomer(customer);
            orderCopied.setPhone(phone);

            List<OrderItemJpa> items = new ArrayList<>();
            for (OrderItem orderItem : order.getItems()) {
                OrderItemJpa item = new OrderItemJpa();
                PropertyUtils.copyProperties(orderItem, item);
                items.add(item);
            }

            orderCopied.setItems(items);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderCopied;
    }
}
