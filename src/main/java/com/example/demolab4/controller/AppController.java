package com.example.demolab4.controller;

import com.example.demolab4.domain.App;

import java.util.List;

public interface AppController extends GeneralController<App,Integer>{
    List<App> getAllFreeApps();
    List<App> getAppsByCategory(String name);
}
