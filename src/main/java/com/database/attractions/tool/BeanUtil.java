package com.database.attractions.tool;

import com.database.attractions.bean.trade.TradeDetail;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.lang.Nullable;

public class BeanUtil implements FactoryBean<TradeDetail> {
    @Nullable
    public TradeDetail getObject() {
        return new TradeDetail();
    }

    @Nullable
    public Class<?> getObjectType() {
        return TradeDetail.class;
    }

    // 创建bean的方式，单例、多例，默认是多例
    public boolean isSingleton() {
        return false;
    }
}
