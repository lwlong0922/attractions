package com.database.attractions.bean.trade;

import java.util.List;

public class Order {
    private String uid;
    private String name;
    private String telnumber;
    private double price;
    private List<ExtraSpots> extraSpots;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<ExtraSpots> getExtraSpots() {
        return extraSpots;
    }

    public void setExtraSpots(List<ExtraSpots> extraSpots) {
        this.extraSpots = extraSpots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }
}
