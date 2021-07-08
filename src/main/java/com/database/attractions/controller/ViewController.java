package com.database.attractions.controller;

import com.database.attractions.bean.OverView;
import com.database.attractions.bean.SpotOverView;
import com.database.attractions.bean.TicketView;
import com.database.attractions.bean.User;
import com.database.attractions.mapper.ViewMapper;
import com.database.attractions.tool.Preferential;
import com.database.attractions.tool.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ViewController {

    @Autowired
    ViewMapper viewMapper;

    @Autowired
    StatusCode statusCode;

    @Autowired
    Preferential preferential;

    /**
     * 拉取总览视图接口
     */
    @GetMapping(path = "/view/getoverview/{date}")
    public StatusCode getOverView(@PathVariable("date") String date) {
        OverView overView = viewMapper.getOverView(date);
        List<Map<String, Object>> spotOverView = viewMapper.getSpotOverView();
        overView.setSpotOverView(spotOverView);
        statusCode.setStatus(200);
        statusCode.setObject(overView);
        return statusCode;
    }

    /**
     * 拉取票的信息接口
     */
    @GetMapping(path="/view/getticketview/{type}")
    public StatusCode getTicketView(@PathVariable("type") String type){
        //child,0.5 adult elder,8

        List<Map<String, Object>> spotOverView = viewMapper.getSpotOverView();
        for (Map<String, Object> mapList : spotOverView)
            mapList.put("tprice",((Double) mapList.get("tprice"))*preferential.getDiscount(type));

        TicketView ticketView = viewMapper.getTicketView();
        ticketView.setBasePrice(ticketView.getBasePrice()* preferential.getDiscount(type));
        ticketView.setSpotOverView(spotOverView);

        statusCode.setStatus(200);
        statusCode.setObject(ticketView);
        return  statusCode;

    }
}
