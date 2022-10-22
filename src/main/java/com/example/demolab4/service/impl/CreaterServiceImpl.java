package com.example.demolab4.service.impl;

import com.example.demolab4.dao.CreaterDao;
import com.example.demolab4.domain.Creater;
import com.example.demolab4.service.CreaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreaterServiceImpl implements CreaterService {
    @Autowired
    private CreaterDao createrDao;

    @Override
    public List<Creater> findAll() {
        return createrDao.findAll();
    }

    @Override
    public Optional<Creater> findById(Integer id) {
        return createrDao.findById(id);
    }

    @Override
    public int create(Creater creater) {
        return createrDao.create(creater);
    }

    @Override
    public int update(Integer id, Creater creater) {
        return createrDao.update(id,creater);
    }

    @Override
    public int delete(Integer id) {
        return createrDao.delete(id);
    }

    @Override
    public List<Creater> getAllCreatersByWorkBranch(String workBranch) {
        return createrDao.getAllCreatersByWorkBranch(workBranch);
    }

    @Override
    public List<Creater> getCreatersByApp(String appName) {
        return createrDao.getCreatersByApp(appName);
    }
}
