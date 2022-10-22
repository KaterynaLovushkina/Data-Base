package com.example.demolab4.dao;

import com.example.demolab4.domain.App;
import com.example.demolab4.domain.Creater;

import java.util.List;

public interface CreaterDao extends GeneralDao<Creater, Integer>{
    List<Creater> getAllCreatersByWorkBranch(String workBranch);
    List<Creater> getCreatersByApp(String appName);
}
