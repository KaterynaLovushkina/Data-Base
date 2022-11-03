package com.lovushkina.service.impl;

import com.lovushkina.domain.AppCategory;
import com.lovushkina.domain.User;
import com.lovushkina.domain.User;
import com.lovushkina.exception.DataNotFoundException;
import com.lovushkina.repository.UserRepository;
import com.lovushkina.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    final UserRepository userRepository;



    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() ->new DataNotFoundException("User", id));
    }

    @Override
    public User create(User entity) {
        userRepository.save(entity);
        return entity;
    }


    @Override
    public void update(Integer id, User entity) {
        User user = userRepository.findById(id).orElseThrow(() ->new DataNotFoundException("User", id));
        user.setPasswordHash(entity.getPasswordHash());
        user.setFullName(entity.getFullName());
        user.setCountry(entity.getCountry());
        user.setEmail(entity.getEmail());
        userRepository.save(user);
    }


    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}
