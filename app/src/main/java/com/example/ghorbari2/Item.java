package com.example.ghorbari2;

public class Item {
    private String ownerName ;
    private String city;
    private String address;
    private String description;
    private String roomNumber;
    private String size;
    private String rentfee1;
    private String phoneNumber1;


    public String getID() {
        return ID;
    }

    public Item(String ownerName, String city, String address, String description, String roomNumber, String size, String rentfee1, String phoneNumber1, String ID) {
        this.ownerName = ownerName;
        this.city = city;
        this.address = address;
        this.description = description;
        this.roomNumber = roomNumber;
        this.size = size;
        this.rentfee1 = rentfee1;
        this.phoneNumber1 = phoneNumber1;
        this.ID = ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    private String ID;

    public String getRentfee1() {
        return rentfee1;
    }

    public void setRentfee1(String rentfee1) {
        this.rentfee1 = rentfee1;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public Item(String ownerName, String city, String address, String description, String roomNumber, String size, String rentfee1, String phoneNumber1) {
        this.ownerName = ownerName;
        this.city = city;
        this.address = address;
        this.description = description;
        this.roomNumber = roomNumber;
        this.size = size;
        this.rentfee1 = rentfee1;
        this.phoneNumber1 = phoneNumber1;
    }

    public Item(){

    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
