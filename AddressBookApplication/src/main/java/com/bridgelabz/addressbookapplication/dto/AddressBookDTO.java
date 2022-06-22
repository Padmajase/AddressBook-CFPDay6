package com.bridgelabz.addressbookapplication.dto;

public class AddressBookDTO {

    public String name;
    public String address;
    public String city;
    public String state;
    public long zipCode;
    public long phoneNo;


    public AddressBookDTO(String name, String address, String city, String state, long zipCode, long phoneNo) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                ", phoneNo=" + phoneNo +
                '}';
    }
}



