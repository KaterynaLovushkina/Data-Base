package com.example.demolab4.controller.impl;

import com.example.demolab4.controller.AppController;
import com.example.demolab4.domain.App;
import com.example.demolab4.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppControllerImpl implements AppController {
    @Autowired
    private AppService appService;

    @Override
    public List<App> findAll() {
        return appService.findAll();
    }

    @Override
    public Optional<App> findById(Integer id) {
        return appService.findById(id);
    }

    @Override
    public int create(App app) {
        return appService.create(app);
    }

    @Override
    public int update(Integer id, App app) {
        return appService.update(id, app);
    }

    @Override
    public int delete(Integer id) {
        return appService.delete(id);
    }

    @Override
    public List<App> getAllFreeApps() {
        return appService.getAllFreeApps();
    }
    @Override
    public List<App> getAppsByCategory(String name) {
        return appService.getAppsByCategory(name);
    }
}
