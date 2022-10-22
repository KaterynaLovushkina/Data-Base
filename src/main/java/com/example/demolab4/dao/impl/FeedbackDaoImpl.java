package com.example.demolab4.dao.impl;

import com.example.demolab4.dao.FeedbackDao;
import com.example.demolab4.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

    private static final String FIND_ALL = "SELECT * FROM feedback";
    private static final String CREATE = "INSERT feedback(description, created_date, rate, user_id, app_id) " +
            "VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE feedback SET description=?,created_date=?,rate=?,user_id=?,app_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM feedback WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM feedback WHERE id=?";
    private static final String FIND_DESCRIPTION_BY_USER_NAME= """
            SELECT *
                        FROM feedback f JOIN user  ON f.user_id = user.id
                        WHERE user.full_name=?
            """;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Feedback> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Feedback.class));
    }

    @Override
    public Optional<Feedback> findById(Integer id) {
        Optional<Feedback> feedback;
        try {
            feedback = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Feedback.class), id));
        } catch (EmptyResultDataAccessException e) {
            feedback = Optional.empty();
        }
        return feedback;
    }

    @Override
    public int create(Feedback feedback) {
        return jdbcTemplate.update(CREATE, feedback.getDescription(), feedback.getCreated_date(),
                feedback.getRate(), feedback.getUser_id(), feedback.getApp_id());
    }

    @Override
    public int update(Integer id, Feedback feedback) {
        return jdbcTemplate.update(UPDATE, feedback.getDescription(), feedback.getCreated_date(),
                feedback.getRate(), feedback.getUser_id(), feedback.getApp_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<List<Feedback>> getAllFeedbacksByUserName(String userName) {
        Optional<List<Feedback>> feedback;
        try {
            feedback = Optional.of(jdbcTemplate.query(FIND_DESCRIPTION_BY_USER_NAME,
                    BeanPropertyRowMapper.newInstance(Feedback.class), userName));
        } catch (EmptyResultDataAccessException e) {
            feedback = Optional.empty();
        }

        return feedback;
    }
}
