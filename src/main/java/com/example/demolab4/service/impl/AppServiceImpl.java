package com.example.demolab4.service.impl;

import com.example.demolab4.dao.AppCategoryDao;
import com.example.demolab4.dao.AppDao;
import com.example.demolab4.domain.App;
import com.example.demolab4.domain.AppCategory;
import com.example.demolab4.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppDao appDao;

    @Override
    public List<App> findAll() {
        return appDao.findAll();
    }

    @Override
    public Optional<App> findById(Integer id) {
        return appDao.findById(id);
    }

    @Override
    public int create(App app) {
        return appDao.create(app);
    }

    @Override
    public int update(Integer id, App app) {
        return appDao.update(id,app);
    }

    @Override
    public int delete(Integer id) {
        return appDao.delete(id);
    }

    @Override
    public List<App> getAllFreeApps() {
        return appDao.getAllFreeApps();
    }
    @Override
    public List<App> getAppsByCategory(String name) {
        return appDao.getAppsByCategory(name);
    }
}
