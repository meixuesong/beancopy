package cn.meixs.beancopy.domain;

public class Address {
    private String province;
    private String city;
    private String streetAddress;

    public Address(String province, String city, String streetAddress) {
        this.province = province;
        this.city = city;
        this.streetAddress = streetAddress;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

}
