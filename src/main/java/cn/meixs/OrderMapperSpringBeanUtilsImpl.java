package cn.meixs;

import cn.meixs.beancopy.domain.Order;
import cn.meixs.beancopy.domain.OrderItem;
import cn.meixs.cn.beancopy.repository.AddressJpa;
import cn.meixs.cn.beancopy.repository.CustomerJpa;
import cn.meixs.cn.beancopy.repository.OrderItemJpa;
import cn.meixs.cn.beancopy.repository.OrderJpa;
import cn.meixs.cn.beancopy.repository.PhoneJpa;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Use Spring BeanUtils to copy values.
 */
public class OrderMapperSpringBeanUtilsImpl implements OrderMapper {
    @Override
    public OrderJpa fromOrder(Order order) {
        OrderJpa orderCopied = new OrderJpa();
        BeanUtils.copyProperties(order, orderCopied, "items");
        BeanUtils.copyProperties(order.getDeliverAddress(), orderCopied);
        CustomerJpa customer = new CustomerJpa();
        BeanUtils.copyProperties(order.getCustomer(), customer);
        AddressJpa homeAddress = new AddressJpa();
        BeanUtils.copyProperties(order.getCustomer().getHomeAddress(), homeAddress);
        customer.setHomeAddress(homeAddress);
        PhoneJpa phone = new PhoneJpa();
        BeanUtils.copyProperties(order.getPhone(), phone);

        orderCopied.setCustomer(customer);
        orderCopied.setPhone(phone);

        List<OrderItemJpa> items = new ArrayList<>();
        for (OrderItem orderItem : order.getItems()) {
            OrderItemJpa item = new OrderItemJpa();
            BeanUtils.copyProperties(orderItem, item);
            items.add(item);
        }

        orderCopied.setItems(items);

        return orderCopied;
    }
}
