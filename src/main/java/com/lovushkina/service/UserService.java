package com.lovushkina.service;

import com.lovushkina.domain.User;

public interface UserService extends GeneralService<User,Integer>{
    void createTablesWithСursor();
}
