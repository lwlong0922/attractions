package com.database.attractions.bean.trade;

public class TradeDetail {
    private long tradeID;
    private int sid;
    private String userID;
    private double tPrice;

    public double gettPrice() {
        return tPrice;
    }

    public void settPrice(double tPrice) {
        this.tPrice = tPrice;
    }

    public long getTradeID() {
        return tradeID;
    }

    public void setTradeID(long tradeID) {
        this.tradeID = tradeID;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }



}
