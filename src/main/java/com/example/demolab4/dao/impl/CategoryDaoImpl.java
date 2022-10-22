package com.example.demolab4.dao.impl;

import com.example.demolab4.dao.CategoryDao;
import com.example.demolab4.domain.App;
import com.example.demolab4.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    private static final String FIND_ALL = "SELECT * FROM category";
    private static final String CREATE = "INSERT category(audience_type, app_category_id)VALUES (?,?)";
    private static final String UPDATE = "UPDATE category SET audience_type=?,app_category_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM category WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM category WHERE id=?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Category.class));
    }


    @Override
    public Optional<Category> findById(Integer id) {
        Optional<Category> download;
        try {
            download = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Category.class), id));
        } catch (EmptyResultDataAccessException e) {
            download = Optional.empty();
        }
        return download;
    }

    @Override
    public int create(Category category) {
        return jdbcTemplate.update(CREATE, category.getAudience_type(), category.getApp_category_id());
    }

    @Override
    public int update(Integer id, Category category) {
        return jdbcTemplate.update(UPDATE, category.getAudience_type(), category.getApp_category_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }


}
