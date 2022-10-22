package com.example.demolab4.service.impl;

import com.example.demolab4.dao.AppCategoryDao;
import com.example.demolab4.domain.AppCategory;
import com.example.demolab4.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {

    @Autowired
    private AppCategoryDao appCategoryDao;

    @Override
    public List<AppCategory> findAll() {
        return appCategoryDao.findAll();
    }

    @Override
    public Optional<AppCategory> findById(Integer id) {
        return appCategoryDao.findById(id);
    }

    @Override
    public int create(AppCategory appCategory) {
        return appCategoryDao.create(appCategory);
    }

    @Override
    public int update(Integer id, AppCategory appCategory) {
        return appCategoryDao.update(id,appCategory);
    }

    @Override
    public int delete(Integer id) {
        return appCategoryDao.delete(id);
    }
}
