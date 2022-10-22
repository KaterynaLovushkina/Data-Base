package com.example.demolab4.service;

import com.example.demolab4.domain.User;

import java.util.List;

public interface UserService extends GeneralService<User, Integer>{
    List<User> getUsersByApp(String appName);
}
