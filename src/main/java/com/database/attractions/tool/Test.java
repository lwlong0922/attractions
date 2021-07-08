package com.database.attractions.tool;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Test {
    private Map<String,Double> preferentialMap=new HashMap<>();
    Test(){
        preferentialMap.put("child",0.5);
        preferentialMap.put("adult",1.0);
        preferentialMap.put("elder",0.8);
    }

    public Double hello(String type){
        return preferentialMap.get(type);
    }
}
