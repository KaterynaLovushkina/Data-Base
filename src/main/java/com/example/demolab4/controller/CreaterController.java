package com.example.demolab4.controller;

import com.example.demolab4.domain.Creater;

import java.util.List;

public interface CreaterController extends GeneralController<Creater,Integer>{
    List<Creater> getAllCreatersByWorkBranch(String workBranch);
    List<Creater> getCreatersByApp(String appName);
}
