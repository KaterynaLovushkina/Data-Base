package com.example.demolab4.dao;

import com.example.demolab4.domain.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackDao extends GeneralDao<Feedback, Integer>{
    Optional<List<Feedback>> getAllFeedbacksByUserName(String userName);
}
