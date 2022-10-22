package com.example.demolab4.service.impl;

import com.example.demolab4.dao.UserDao;
import com.example.demolab4.domain.User;
import com.example.demolab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public int create(User user) {
        return userDao.create(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userDao.update(id,user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public List<User> getUsersByApp(String appName) {
        return userDao.getUsersByApp(appName);
    }
}
