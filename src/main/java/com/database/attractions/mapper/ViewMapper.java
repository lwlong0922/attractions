package com.database.attractions.mapper;

import com.database.attractions.bean.OverView;
import com.database.attractions.bean.SpotOverView;
import com.database.attractions.bean.TicketView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ViewMapper {
    OverView getOverView(String date);
    List<Map<String, Object>> getSpotOverView();
    TicketView getTicketView();

}
