package com.lovushkina.service;

import com.lovushkina.domain.AppCategory;

public interface AppCategoryService extends GeneralService<AppCategory,Integer>{
    void insert10Rows(String name, String description);
}
