package com.example.demolab4.controller.impl;

import com.example.demolab4.controller.UserController;
import com.example.demolab4.domain.App;
import com.example.demolab4.domain.User;
import com.example.demolab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userService.findById(id);
    }

    @Override
    public int create(User user) {
        return userService.create(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userService.update(id, user);
    }

    @Override
    public int delete(Integer id) {
        return userService.delete(id);
    }

    @Override
    public List<User> getUsersByApp(String appName) {
        return userService.getUsersByApp(appName);
    }
}
