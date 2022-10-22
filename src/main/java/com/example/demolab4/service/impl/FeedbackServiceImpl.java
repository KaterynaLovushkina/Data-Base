package com.example.demolab4.service.impl;

import com.example.demolab4.dao.FeedbackDao;
import com.example.demolab4.domain.Feedback;
import com.example.demolab4.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    public List<Feedback> findAll() {
        return feedbackDao.findAll();
    }

    @Override
    public Optional<Feedback> findById(Integer id) {
        return feedbackDao.findById(id);
    }

    @Override
    public int create(Feedback feedback) {
        return feedbackDao.create(feedback);
    }

    @Override
    public int update(Integer id, Feedback feedback) {
        return feedbackDao.update(id,feedback);
    }

    @Override
    public int delete(Integer id) {
        return feedbackDao.delete(id);
    }

    @Override
    public Optional<List<Feedback>> getAllFeedbacksByUserName(String userName) {
        return feedbackDao.getAllFeedbacksByUserName(userName);
    }
}
