package com.lovushkina.service.impl;

import com.lovushkina.domain.App;
import com.lovushkina.domain.AppCategory;
import com.lovushkina.domain.Category;
import com.lovushkina.domain.Creater;
import com.lovushkina.exception.DataNotFoundException;
import com.lovushkina.repository.CreaterRepository;
import com.lovushkina.service.CreaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor

@Service
public class CreaterServiceImpl implements CreaterService {
    @Autowired
    final CreaterRepository createrRepository;


    @Override
    public List<Creater> findAll() {
        return createrRepository.findAll();
    }

    @Override
    public Creater findById(Integer id) {
        return createrRepository.findById(id).orElseThrow(() ->new DataNotFoundException("Creater", id));
    }

    @Override
    public Creater create(Creater entity) {
        createrRepository.save(entity);
        return entity;
    }

    @Override
    public void update(Integer id, Creater entity) {
        Creater creater = createrRepository.findById(id).orElseThrow(() ->new DataNotFoundException("Creater", id));
        creater.setFullName(entity.getFullName());
        creater.setWorkBranch(entity.getWorkBranch());
        creater.setEmail(entity.getEmail());
        creater.setCreatedAppAmount(entity.getCreatedAppAmount());
        createrRepository.save(creater);
    }


    @Override
    public void delete(Integer id) {
        createrRepository.deleteById(id);
    }


    @Override
    public List<App> getAppsByCreaterId(Integer id) {
        Creater creater = createrRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Creater", id));
        return creater.getApps().stream().toList();
    }
}
