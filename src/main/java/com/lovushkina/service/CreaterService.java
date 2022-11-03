package com.lovushkina.service;

import com.lovushkina.domain.App;
import com.lovushkina.domain.Creater;

import java.util.List;

public interface CreaterService extends GeneralService<Creater,Integer>{
    List<App> getAppsByCreaterId(Integer id);
}
