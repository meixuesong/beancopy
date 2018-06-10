package cn.meixs.cn.beancopy.repository;

public class CustomerJpa {
    private String customerNo;
    private String name;
    private AddressJpa homeAddress;
    private PhoneJpa mobilePhone;

    public CustomerJpa(String customerNo, String name, AddressJpa homeAddress, PhoneJpa mobilePhone) {
        this.customerNo = customerNo;
        this.name = name;
        this.homeAddress = homeAddress;
        this.mobilePhone = mobilePhone;
    }

    public CustomerJpa() {
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressJpa getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(AddressJpa homeAddress) {
        this.homeAddress = homeAddress;
    }

    public PhoneJpa getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(PhoneJpa mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
