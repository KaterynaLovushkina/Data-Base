package com.example.demolab4.service;

import com.example.demolab4.domain.App;

import java.util.List;

public interface AppService extends GeneralService<App, Integer> {
    List<App> getAllFreeApps();
    List<App> getAppsByCategory(String name);
}
