package com.example.demolab4.controller.impl;

import com.example.demolab4.controller.CategoryController;
import com.example.demolab4.domain.App;
import com.example.demolab4.domain.Category;
import com.example.demolab4.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoryControllerImpl implements CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Override
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public int create(Category category) {
        return categoryService.create(category);
    }

    @Override
    public int update(Integer id, Category category) {
        return categoryService.update(id, category);
    }

    @Override
    public int delete(Integer id) {
        return categoryService.delete(id);
    }

}
