package com.example.demolab4.controller.impl;

import com.example.demolab4.controller.CreaterController;
import com.example.demolab4.domain.Category;
import com.example.demolab4.domain.Creater;
import com.example.demolab4.service.CreaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CreaterControllerImpl implements CreaterController {
    @Autowired
    private CreaterService createrService;

    @Override
    public List<Creater> findAll() {
        return createrService.findAll();
    }

    @Override
    public Optional<Creater> findById(Integer id) {
        return createrService.findById(id);
    }

    @Override
    public int create(Creater creater) {
        return createrService.create(creater);
    }

    @Override
    public int update(Integer id, Creater creater) {
        return createrService.update(id, creater);
    }

    @Override
    public int delete(Integer id) {
        return createrService.delete(id);
    }

    @Override
    public List<Creater> getAllCreatersByWorkBranch(String workBranch) {
        return createrService.getAllCreatersByWorkBranch(workBranch);
    }

    @Override
    public List<Creater> getCreatersByApp(String appName) {
        return createrService.getCreatersByApp(appName);
    }
}
