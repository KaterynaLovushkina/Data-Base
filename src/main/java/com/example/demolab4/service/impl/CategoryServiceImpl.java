package com.example.demolab4.service.impl;

import com.example.demolab4.dao.CategoryDao;
import com.example.demolab4.domain.App;
import com.example.demolab4.domain.Category;
import com.example.demolab4.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryDao.findById(id);
    }

    @Override
    public int create(Category category) {
        return categoryDao.create(category);
    }

    @Override
    public int update(Integer id, Category category) {
        return categoryDao.update(id,category);
    }

    @Override
    public int delete(Integer id) {
        return categoryDao.delete(id);
    }
}

