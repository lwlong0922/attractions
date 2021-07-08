package com.database.attractions.bean;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class OverView {
    private String aname;
    private int remain;
    private List<Map<String, Object>> spotOverView;

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public List<Map<String, Object>> getSpotOverView() {
        return spotOverView;
    }

    public void setSpotOverView(List<Map<String, Object>> spotOverView) {
        this.spotOverView = spotOverView;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }




}
