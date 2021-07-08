package com.database.attractions.mapper;

import com.database.attractions.bean.ScenicArea;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AdminMapper {
    List<Map<String,Object>> getScenicAreas();
    void updataScenicAreas(ScenicArea scenicArea);
    void updataPrice(int sid,double price);
}
