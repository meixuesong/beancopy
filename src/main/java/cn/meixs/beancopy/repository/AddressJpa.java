package cn.meixs.beancopy.repository;

public class AddressJpa {
    private String province;
    private String city;
    private String streetAddress;

    public AddressJpa() {
    }

    public AddressJpa(String province, String city, String streetAddress) {
        this.province = province;
        this.city = city;
        this.streetAddress = streetAddress;
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
