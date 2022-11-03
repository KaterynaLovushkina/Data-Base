package com.lovushkina.service.impl;

import com.lovushkina.domain.App;
import com.lovushkina.domain.Category;
import com.lovushkina.domain.User;
import com.lovushkina.exception.DataNotFoundException;
import com.lovushkina.repository.AppRepository;
import com.lovushkina.repository.CategoryRepository;
import com.lovushkina.repository.UserRepository;
import com.lovushkina.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppServiceImpl implements AppService {
    @Autowired
    final AppRepository appRepository;

    @Autowired
    final CategoryRepository categoryRepository;


    @Override
    public List<App> findAll() {
        return appRepository.findAll();
    }

    @Override
    public App findById(Integer id) {
        return appRepository.findById(id).orElseThrow(() ->new DataNotFoundException("App", id));
    }

    @Override
    public App create(App entity) {
        appRepository.save(entity);
        return entity;
    }
    @Override
    public App create(App app, Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->new DataNotFoundException("Category", categoryId));
        app.setCategory(category);
        return appRepository.save(app);
    }

    @Override
    public List<App> getAppsByCategoryId(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->new DataNotFoundException("Category", categoryId));
        return category.getApps();
    }

    @Override
    public List<App> getAllFreeApps() {
        return appRepository.getAllFreeApps();
    }


    @Override
    public void update(Integer id, App entity) {
        App app = appRepository.findById(id).orElseThrow(() ->new DataNotFoundException("App", id));

        app.setName(entity.getName());
        app.setDescription(entity.getDescription());
        app.setWeightInMb(entity.getWeightInMb());
        app.setCreateDate(entity.getCreateDate());
        app.setIsFree(entity.getIsFree());
        app.setPriceInDollars(entity.getPriceInDollars());
        app.setHasAdvert(entity.getHasAdvert());

        appRepository.save(app);
    }

    @Override
    public void update(Integer appId, App entity, Integer categoryId) {
        App app = appRepository.findById(appId).orElseThrow(() ->new DataNotFoundException("App", appId));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->new DataNotFoundException("Category", categoryId));
        app.setName(entity.getName());
        app.setDescription(entity.getDescription());
        app.setWeightInMb(entity.getWeightInMb());
        app.setCreateDate(entity.getCreateDate());
        app.setIsFree(entity.getIsFree());
        app.setPriceInDollars(entity.getPriceInDollars());
        app.setHasAdvert(entity.getHasAdvert());
        app.setCategory(category);
        appRepository.save(app);

    }

    @Override
    public void delete(Integer id) {
        appRepository.deleteById(id);
    }


}
