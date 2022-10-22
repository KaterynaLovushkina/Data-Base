package com.example.demolab4.service;

import com.example.demolab4.domain.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackService extends GeneralService<Feedback, Integer>{
    Optional<List<Feedback>> getAllFeedbacksByUserName(String userName);
}
