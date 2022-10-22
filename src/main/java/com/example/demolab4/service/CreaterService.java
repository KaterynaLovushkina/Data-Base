package com.example.demolab4.service;

import com.example.demolab4.domain.Creater;

import java.util.List;

public interface CreaterService extends GeneralService<Creater, Integer>{
    List<Creater> getAllCreatersByWorkBranch(String workBranch);
    List<Creater> getCreatersByApp(String appName);;
}
