package com.database.attractions.mapper;

import com.database.attractions.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper {
    User userLogin(String userid,String password);
    void userRegister(User user);
    void UserUpdate(User user);
    String getName(String userID);
}
