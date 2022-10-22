package com.example.demolab4.controller.impl;

import com.example.demolab4.controller.AppCategoryController;
import com.example.demolab4.domain.AppCategory;
import com.example.demolab4.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class AppCategoryControllerImpl implements AppCategoryController {
    @Autowired
    private AppCategoryService appCategoryService;

    @Override
    public List<AppCategory> findAll() {
        return appCategoryService.findAll();
    }

    @Override
    public Optional<AppCategory> findById(Integer id) {
        return appCategoryService.findById(id);
    }

    @Override
    public int create(AppCategory appCategory) {
        return appCategoryService.create(appCategory);
    }

    @Override
    public int update(Integer id, AppCategory appCategory) {
        return appCategoryService.update(id, appCategory);
    }

    @Override
    public int delete(Integer id) {
        return appCategoryService.delete(id);
    }
}
