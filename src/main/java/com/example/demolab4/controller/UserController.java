package com.example.demolab4.controller;

import com.example.demolab4.domain.User;

import java.util.List;

public interface UserController extends GeneralController<User,Integer>{

    List<User> getUsersByApp(String appName);
}
