package com.database.attractions.tool;

import com.database.attractions.bean.Trade;
import com.database.attractions.bean.trade.ExtraSpots;
import com.database.attractions.bean.trade.Order;
import com.database.attractions.bean.trade.TradeDetail;
import com.database.attractions.config.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TradeUtil {

    @Autowired
    Preferential preferential;

    public List<TradeDetail> getTradeDetails(Trade trade){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
        BeanUtil tradeDetailFactory = ctx.getBean(BeanUtil.class);

        List<TradeDetail> tradeDetails = new ArrayList<>();

        for (Order order:trade.getOrders()) {
            TradeDetail baseTradeDetail = tradeDetailFactory.getObject();
            baseTradeDetail.setTradeID(trade.getTradeID());
            baseTradeDetail.setUserID(order.getUid());
            baseTradeDetail.setSid(-1);
            baseTradeDetail.settPrice(order.getPrice());
            tradeDetails.add(baseTradeDetail);

            for (ExtraSpots extraSpots:order.getExtraSpots()) {
                TradeDetail tradeDetail = tradeDetailFactory.getObject();
                tradeDetail.setTradeID(trade.getTradeID());
                tradeDetail.setUserID(order.getUid());
                tradeDetail.setSid(extraSpots.getSid());
                tradeDetail.settPrice(extraSpots.getTprice());
                tradeDetails.add(tradeDetail);
            }
        }


        return tradeDetails;
    }

    public Trade setTradeID(Trade trade){
        // 生成id
        Long Ts = System.currentTimeMillis();
        String Tss=""+Ts;
        Tss = Tss.substring(0,12);
        int randInt=new Random().nextInt(99);
        if (randInt<10) Tss += '0';
        Tss+=randInt;
        trade.setTradeID(Long.parseLong(Tss));
        return trade;
    }

    public Trade setTradeDate(Trade trade){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        trade.setTradeDate(dateTime.format(formatter));
        return trade;
    }

    public Trade getPeopleNum(Trade trade){
        int NumberOfPeople = trade.getOrders().size();
        trade.setNumberOfPeople(NumberOfPeople);
        return trade;
    }
}
