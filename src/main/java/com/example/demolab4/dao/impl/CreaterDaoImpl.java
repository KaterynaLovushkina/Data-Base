package com.example.demolab4.dao.impl;

import com.example.demolab4.dao.CreaterDao;
import com.example.demolab4.domain.Creater;
import com.example.demolab4.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CreaterDaoImpl implements CreaterDao {
    private static final String FIND_ALL = "SELECT * FROM creater";
    private static final String CREATE = "INSERT creater(full_name,work_branch,email,created_app_amount) " +
            "VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE creater SET full_name=?,work_branch=?,email=?,created_app_amount=? WHERE id=?";
    private static final String DELETE = "DELETE FROM creater WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM creater WHERE id=?";

    private static final String FIND_CREATER_BY_APP_NAME = """
            SELECT *
                        FROM app JOIN app_creating ac ON app.id = ac.app_id
                                 JOIN creater c ON ac.creater_id = c.id
                                 Where app.name = ?""";
    private static  final String FIND_CREATER_BY_WORK_BRANCH = """
            SELECT *
            FROM creater
            WHERE work_branch = ?
            """;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Creater> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Creater.class));
    }

    @Override
    public Optional<Creater> findById(Integer id) {
        Optional<Creater> creater;
        try {
            creater = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Creater.class), id));
        } catch (EmptyResultDataAccessException e) {
            creater = Optional.empty();
        }
        return creater;
    }

    @Override
    public int create(Creater creater) {
        return jdbcTemplate.update(CREATE, creater.getFull_name(), creater.getWork_branch(),
                creater.getEmail(), creater.getCreated_app_amount());
    }

    @Override
    public int update(Integer id, Creater creater) {
        return jdbcTemplate.update(UPDATE, creater.getFull_name(), creater.getWork_branch(),
                creater.getEmail(), creater.getCreated_app_amount(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<Creater> getAllCreatersByWorkBranch(String workBranch) {
        return jdbcTemplate.query(FIND_CREATER_BY_WORK_BRANCH,BeanPropertyRowMapper.newInstance(Creater.class),workBranch);
    }

    @Override
    public List<Creater> getCreatersByApp(String appName){
        return jdbcTemplate.query(FIND_CREATER_BY_APP_NAME,BeanPropertyRowMapper.newInstance(Creater.class),appName);
    }
}
