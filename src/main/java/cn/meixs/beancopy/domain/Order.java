package cn.meixs.beancopy.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private Address deliverAddress;
    private Phone phone;

    private BigDecimal totalMoney;
    private OrderStatus status;

    private Date createDate;
    private Date acceptedDate;
    private Date deliveredDate;

    private List<OrderItem> items;

    public Order(String orderId, Customer customer, Address deliverAddress, Phone phone, BigDecimal totalMoney, OrderStatus status, Date createDate, Date acceptedDate, Date deliveredDate, List<OrderItem> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.deliverAddress = deliverAddress;
        this.phone = phone;
        this.totalMoney = totalMoney;
        this.status = status;
        this.createDate = createDate;
        this.acceptedDate = acceptedDate;
        this.deliveredDate = deliveredDate;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Address getDeliverAddress() {
        return deliverAddress;
    }

    public Phone getPhone() {
        return phone;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getAcceptedDate() {
        return acceptedDate;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
