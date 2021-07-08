package com.database.attractions.bean;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class TicketView {
    private double basePrice;
    private List<Map<String, Object>> spotOverView;

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public List<Map<String, Object>> getSpotOverView() {
        return spotOverView;
    }

    public void setSpotOverView(List<Map<String, Object>> spotOverView) {
        this.spotOverView = spotOverView;
    }
}
