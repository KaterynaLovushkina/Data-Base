package com.example.demolab4.controller.impl;

import com.example.demolab4.controller.FeedbackController;
import com.example.demolab4.domain.App;
import com.example.demolab4.domain.Feedback;
import com.example.demolab4.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class FeedbackControllerImpl implements FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @Override
    public List<Feedback> findAll() {
        return feedbackService.findAll();
    }

    @Override
    public Optional<Feedback> findById(Integer id) {
        return feedbackService.findById(id);
    }

    @Override
    public int create(Feedback feedback) {
        return feedbackService.create(feedback);
    }

    @Override
    public int update(Integer id, Feedback feedback) {
        return feedbackService.update(id, feedback);
    }

    @Override
    public int delete(Integer id) {
        return feedbackService.delete(id);
    }

    @Override
    public Optional<List<Feedback>> getAllFeedbacksByUserName(String userName) {
        return feedbackService.getAllFeedbacksByUserName(userName);
    }
}
