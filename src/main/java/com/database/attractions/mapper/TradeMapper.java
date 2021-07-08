package com.database.attractions.mapper;

import com.database.attractions.bean.Trade;
import com.database.attractions.bean.trade.TradeDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TradeMapper {
    void insertTrade(Trade trade);
    int insertTradeDetail(@Param("list")  List<TradeDetail> list);
    void refundTrade(Long tradeID);
    List<Map<String,Object>> getTrades(String uid);
    List<Map<String,Object>> getOrders(Long tradeID);
    List<Map<String,Object>> getExtraSpots(Long tradeID,String userID);
}
