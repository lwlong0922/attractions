package com.database.attractions.bean;

public class SpotOverView {
    private int scenicareaID;
    private String sName;
    private double tprice;
    private String sOpenTime;
    private String sAddress;
    private int numberSold;

    public int getScenicareaID() {
        return scenicareaID;
    }

    public void setScenicareaID(int scenicareaID) {
        this.scenicareaID = scenicareaID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }

    public String getsOpenTime() {
        return sOpenTime;
    }

    public void setsOpenTime(String sOpenTime) {
        this.sOpenTime = sOpenTime;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public int getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(int numberSold) {
        this.numberSold = numberSold;
    }


}
