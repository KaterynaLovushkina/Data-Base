package com.example.demolab4.dao;

import com.example.demolab4.domain.App;

import java.util.List;

public interface AppDao extends GeneralDao<App, Integer> {
    List<App> getAllFreeApps();
    List<App> getAppsByCategory(String name);
}
