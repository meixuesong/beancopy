package cn.meixs.beancopy.repository;

public class PhoneJpa {
    String phoneNo;

    public PhoneJpa() {
    }

    public PhoneJpa(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
