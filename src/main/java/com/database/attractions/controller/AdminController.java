package com.database.attractions.controller;

import com.database.attractions.bean.ScenicArea;
import com.database.attractions.mapper.AdminMapper;
import com.database.attractions.tool.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    StatusCode statusCode;

    @Autowired
    AdminMapper adminMapper;


    @GetMapping(path = "/admin/getScenicAreas")
    public StatusCode getScenicAreas(){
        statusCode.setStatus(200);
        List<Map<String ,Object>> resultList = adminMapper.getScenicAreas();
        statusCode.setObject(resultList);
        return statusCode;
    }

    @PostMapping(path="/admin/updataScenicAreas")
    public StatusCode updataScenicAreas(@RequestBody ScenicArea scenicArea){
        adminMapper.updataScenicAreas(scenicArea);
        adminMapper.updataPrice(scenicArea.getSid(),scenicArea.getPrice());
        statusCode.setStatus(200);
        statusCode.setObject(scenicArea);
        return statusCode;
    }
}
