package com.database.attractions.controller;

import com.database.attractions.bean.Trade;
import com.database.attractions.bean.trade.ExtraSpots;
import com.database.attractions.bean.trade.Order;
import com.database.attractions.bean.trade.TradeDetail;
import com.database.attractions.config.BeanConfig;
import com.database.attractions.mapper.TradeMapper;
import com.database.attractions.tool.BeanUtil;
import com.database.attractions.tool.StatusCode;
import com.database.attractions.tool.TradeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class TradeController {

    @Autowired
    StatusCode statusCode;

    @Autowired
    TradeMapper tradeMapper;

    @Autowired
    TradeUtil tradeUtil;

    /**
     * post交易单信息
     */
    @PostMapping(path = "/trade/posttrade")
    public StatusCode postTrade(@RequestBody Trade trade){

        //设置生成的id
        trade = tradeUtil.setTradeID(trade);
        trade = tradeUtil.getPeopleNum(trade);
        trade = tradeUtil.setTradeDate(trade);

        //转化为链表
        List<TradeDetail> tradeDetails = tradeUtil.getTradeDetails(trade);

        //插入
        tradeMapper.insertTrade(trade);

        int i=tradeMapper.insertTradeDetail(tradeDetails);



        statusCode.setStatus(200);
        statusCode.setObject(trade);
        return statusCode;
    }

    @GetMapping(path="/trade/gettrade/{uid}")
    public StatusCode getTrade(@PathVariable("uid") String uid){
        List<Map<String,Object>> resultList=tradeMapper.getTrades(uid);
        for (Map<String,Object> mapList: resultList) {
            mapList.put("tradeDate",((LocalDateTime) mapList.get("tradeDate")).format(DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm:ss")));
            List<Map<String,Object>> orderList = tradeMapper.getOrders((Long) mapList.get("tradeID"));
            mapList.put("orders",orderList);
        }
        statusCode.setStatus(200);
        statusCode.setObject(resultList);
        return  statusCode;
    }

    @GetMapping(path="/trade/getextraspots/tradeID={tradeID}&userID={userID}")
    public StatusCode getExtraSpots(@PathVariable("tradeID") Long tradeID,@PathVariable("userID") String userID){
        List<Map<String,Object>> resultList=tradeMapper.getExtraSpots(tradeID,userID);
        statusCode.setStatus(200);
        statusCode.setObject(resultList);
        return statusCode;
    }

    @GetMapping(path="/trade/refundTrade/{tradeID}")
    public StatusCode refundTrade(@PathVariable("tradeID") Long tradeID){
        tradeMapper.refundTrade(tradeID);
        statusCode.setStatus(200);
        statusCode.setObject("退票成功");
        return statusCode;
    }
}
