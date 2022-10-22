package com.example.demolab4.controller;

import com.example.demolab4.domain.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackController extends GeneralController<Feedback,Integer>{
    Optional<List<Feedback>> getAllFeedbacksByUserName(String userName);
}
