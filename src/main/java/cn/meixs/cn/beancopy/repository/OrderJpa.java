package cn.meixs.cn.beancopy.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderJpa {
    private String orderId;
    private CustomerJpa customer;

    //demonstrate a flat address, which is a Address class in the Order domain.
    private String province;
    private String city;
    private String streetAddress;

    private PhoneJpa phone;

    private BigDecimal totalMoney;
    private String status;

    private Date createDate;
    private Date acceptedDate;
    private Date deliveredDate;

    private List<OrderItemJpa> items;

    public OrderJpa() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public CustomerJpa getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerJpa customer) {
        this.customer = customer;
    }

    public PhoneJpa getPhone() {
        return phone;
    }

    public void setPhone(PhoneJpa phone) {
        this.phone = phone;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(Date acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public List<OrderItemJpa> getItems() {
        return items;
    }

    public void setItems(List<OrderItemJpa> items) {
        this.items = items;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}
