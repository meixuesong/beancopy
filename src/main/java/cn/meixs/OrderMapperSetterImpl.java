package cn.meixs;

import cn.meixs.beancopy.domain.Customer;
import cn.meixs.beancopy.domain.Order;
import cn.meixs.beancopy.domain.OrderItem;
import cn.meixs.beancopy.repository.AddressJpa;
import cn.meixs.beancopy.repository.CustomerJpa;
import cn.meixs.beancopy.repository.OrderItemJpa;
import cn.meixs.beancopy.repository.OrderJpa;
import cn.meixs.beancopy.repository.PhoneJpa;

import java.util.ArrayList;
import java.util.List;

/**
 * Use hard code setter to copy beans.
 */
public class OrderMapperSetterImpl implements OrderMapper {
    @Override
    public OrderJpa fromOrder(Order order) {
        OrderJpa orderCopied = new OrderJpa();
        orderCopied.setPhone(new PhoneJpa(order.getPhone().getPhoneNo()));
        Customer customer = order.getCustomer();
        orderCopied.setCustomer(new CustomerJpa(customer.getCustomerNo(), customer.getName(),
                new AddressJpa(customer.getHomeAddress().getProvince(), customer.getHomeAddress().getCity(), customer.getHomeAddress().getStreetAddress())
                , new PhoneJpa(customer.getMobilePhone().getPhoneNo())));
        orderCopied.setAcceptedDate(order.getAcceptedDate());
        orderCopied.setCreateDate(order.getCreateDate());
        orderCopied.setDeliveredDate(order.getDeliveredDate());
        orderCopied.setCity(order.getDeliverAddress().getCity());
        orderCopied.setOrderId(order.getOrderId());
        orderCopied.setProvince(order.getDeliverAddress().getProvince());
        orderCopied.setStatus(order.getStatus().toString());
        orderCopied.setStreetAddress(order.getDeliverAddress().getStreetAddress());
        orderCopied.setTotalMoney(order.getTotalMoney());

        List<OrderItemJpa> items = new ArrayList<>();
        for (OrderItem orderItem : order.getItems()) {
            OrderItemJpa item = new OrderItemJpa();
            item.setComment(orderItem.getComment());
            item.setPrice(orderItem.getPrice());
            item.setProductId(orderItem.getProductId());
            item.setQuantity(orderItem.getQuantity());
            items.add(item);
        }

        orderCopied.setItems(items);

        return orderCopied;
    }
}
