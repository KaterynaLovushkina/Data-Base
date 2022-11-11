package com.lovushkina.service.impl;

import com.lovushkina.domain.App;
import com.lovushkina.domain.EmailPreferences;
import com.lovushkina.domain.EmailPreferences;
import com.lovushkina.domain.User;
import com.lovushkina.exception.DataNotFoundException;
import com.lovushkina.repository.AppRepository;
import com.lovushkina.repository.EmailPreferencesRepository;
import com.lovushkina.repository.UserRepository;
import com.lovushkina.service.EmailPreferencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor

@Service
public class EmailPreferencesServiceImpl implements EmailPreferencesService {
    @Autowired
    final EmailPreferencesRepository emailPreferencesRepository;

   ;

    @Override
    public List<EmailPreferences> findAll() {
        return emailPreferencesRepository.findAll();
    }

    @Override
    public EmailPreferences findById(String email) {
        return emailPreferencesRepository.findById(email).orElseThrow(() ->new DataNotFoundException("AppCategory", email));
    }

    @Override
    public EmailPreferences create(EmailPreferences entity) {
        emailPreferencesRepository.save(entity);
        return entity;
    }

    @Override
    public void update(String email, EmailPreferences entity) {
        EmailPreferences emailPreferences = emailPreferencesRepository.findById(email).orElseThrow(() ->new DataNotFoundException("EmailPreferences", email));
        emailPreferences.setEmail(entity.getEmail());
        emailPreferences.setKeepWithUpToDateNews(entity.getKeepWithUpToDateNews());
        emailPreferences.setReceiveReplyNotification(entity.getReceiveReplyNotification());
        emailPreferences.setUserId(entity.getUserId());
        emailPreferencesRepository.save(emailPreferences);
    }



    @Override
    public void delete(String email) {
        emailPreferencesRepository.deleteById(email);
    }

}
