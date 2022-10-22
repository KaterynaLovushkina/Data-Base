package com.example.demolab4.dao;

import com.example.demolab4.domain.User;

import java.util.List;

public interface UserDao extends GeneralDao<User, Integer>{
    List<User> getUsersByApp(String appName);
}
