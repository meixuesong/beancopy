package cn.meixs;

import cn.meixs.beancopy.domain.Address;
import cn.meixs.beancopy.domain.Customer;
import cn.meixs.beancopy.domain.Order;
import cn.meixs.beancopy.domain.OrderItem;
import cn.meixs.beancopy.domain.Phone;
import cn.meixs.cn.beancopy.repository.AddressJpa;
import cn.meixs.cn.beancopy.repository.CustomerJpa;
import cn.meixs.cn.beancopy.repository.OrderItemJpa;
import cn.meixs.cn.beancopy.repository.OrderJpa;
import cn.meixs.cn.beancopy.repository.PhoneJpa;

import java.util.stream.Collectors;

/**
 * Use cglib BeanCopier to copy values.
 */
public class OrderMapperCglibImpl extends BaseMapper implements OrderMapper {

    {
        register(Order.class, OrderJpa.class);
        register(Customer.class, CustomerJpa.class);
        register(Phone.class, PhoneJpa.class);
        register(OrderItem.class, OrderItemJpa.class);
        register(Address.class, OrderJpa.class);
        register(Address.class, AddressJpa.class);
    }

    @Override
    public OrderJpa fromOrder(Order order) {
        OrderJpa orderCopied = create(OrderJpa.class, order);
        copy(order.getDeliverAddress(), orderCopied);

        CustomerJpa customer = create(CustomerJpa.class, order.getCustomer());
        customer.setHomeAddress(create(AddressJpa.class, order.getCustomer().getHomeAddress()));

        orderCopied.setCustomer(customer);
        orderCopied.setPhone(create(PhoneJpa.class, order.getPhone()));

        orderCopied.setItems(order.getItems().stream().map(item -> create(OrderItemJpa.class, item)).collect(Collectors.toList()));

        return orderCopied;
    }


}






















