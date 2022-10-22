package com.example.demolab4.dao.impl;

import com.example.demolab4.dao.AppCategoryDao;
import com.example.demolab4.domain.App;
import com.example.demolab4.domain.AppCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AppCategoryDaoImpl implements AppCategoryDao {
    private static final String FIND_ALL = "SELECT * FROM app_category";
    private static final String CREATE = "INSERT app_category(name,description)VALUES (?,?)";
    private static final String UPDATE = "UPDATE app_category SET name=?,description=? WHERE id=?";
    private static final String DELETE = "DELETE FROM app_category WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM app_category WHERE id=?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AppCategory> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(AppCategory.class));
    }


    @Override
    public Optional<AppCategory> findById(Integer id) {
        Optional<AppCategory> appCategory;
        try {
            appCategory = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(AppCategory.class), id));
        } catch (EmptyResultDataAccessException e) {
            appCategory = Optional.empty();
        }
        return appCategory;
    }

    @Override
    public int create(AppCategory appCategory) {
        return jdbcTemplate.update(CREATE, appCategory.getName(), appCategory.getDescription());
    }

    @Override
    public int update(Integer id, AppCategory appCategory) {
        return jdbcTemplate.update(UPDATE, appCategory.getName(),
                                   appCategory.getDescription(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

}
