package cn.meixs.beancopy.domain;

public class Customer {
    private String customerNo;
    private String name;
    private Address homeAddress;
    private Phone mobilePhone;

    public Customer(String customerNo, String name, Address homeAddress, Phone mobilePhone) {
        this.customerNo = customerNo;
        this.name = name;
        this.homeAddress = homeAddress;
        this.mobilePhone = mobilePhone;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public String getName() {
        return name;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public Phone getMobilePhone() {
        return mobilePhone;
    }
}