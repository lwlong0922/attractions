package com.database.attractions.tool;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Preferential {
    private static Map<String,Double> preferentialMap=new HashMap<>();
    Preferential(){
        preferentialMap.put("child",0.5);
        preferentialMap.put("adult",1.0);
        preferentialMap.put("elder",0.8);
    }

    public Double getDiscount(String type){
        return preferentialMap.get(type);
    }
}
