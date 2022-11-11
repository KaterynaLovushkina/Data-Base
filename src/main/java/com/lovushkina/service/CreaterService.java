package com.lovushkina.service;

import com.lovushkina.domain.App;
import com.lovushkina.domain.Creater;

import java.util.List;

public interface CreaterService extends GeneralService<Creater,Integer>{
    List<App> getAppsByCreaterId(Integer id);
    Creater insertCreaterWithProcedures(String full_name, String work_branch,
                                        String email, Integer created_app_amount);
    void addManyToManyRelationShip(String app_name, String creater_full_name);
    Integer findMaxAppCount();

}
