package com.entity;

import jakarta.persistence.Column;

public class BookingInfo {
    private int id;
    private String fromLocation;
    private String toLocation;
    private String email;
    private String typeOfCab;
    private int price;

    public BookingInfo(int price, int id, String fromLocation, String toLocation, String typeOfCab, String email) {
        this.price = price;
        this.id = id;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.typeOfCab = typeOfCab;
        this.email = email;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeOfCab() {
        return typeOfCab;
    }

    public void setTypeOfCab(String typeOfCab) {
        this.typeOfCab = typeOfCab;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
