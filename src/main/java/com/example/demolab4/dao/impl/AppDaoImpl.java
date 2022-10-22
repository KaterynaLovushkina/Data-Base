package com.example.demolab4.dao.impl;

import com.example.demolab4.dao.AppDao;
import com.example.demolab4.domain.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AppDaoImpl implements AppDao {
    private static final String FIND_ALL = "SELECT * FROM app";
    private static final String CREATE = "INSERT app(name,description,weight_in_mb," +
            "create_date,is_free,price_id_dollars,has_advert,category_id)" +
            "VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE app SET name=?,description=?,weight_in_mb=?," +
            "create_date=?,is_free=?,price_id_dollars=?,has_advert=?,category_id=?" +
            " WHERE id=?";
    private static final String DELETE = "DELETE FROM app WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM app WHERE id=?";

    private static final String FIND_ALL_FREE_APPS = """
            SELECT * FROM app WHERE is_free = true
            """;
    private static final String FIND_BY_CATEGORY_NAME = """
            SELECT *
            FROM app_category  JOIN category c on app_category.id = c.app_category_id
                               JOIN app on c.id = app.category_id
                               WHERE app_category.name = ?
            """;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<App> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(App.class));
    }


    @Override
    public Optional<App> findById(Integer id) {
        Optional<App> app;
        try {
            app = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(App.class), id));
        } catch (EmptyResultDataAccessException e) {
            app = Optional.empty();
        }
        return app;
    }

    @Override
    public int create(App app) {
        return jdbcTemplate.update(CREATE, app.getName(), app.getDescription(),
                app.getWeight_in_mb(),app.getCreate_date(),app.getIs_free(),
                app.getPrice_in_dollars(),app.getHas_advert(),app.getCategory_id());
    }

    @Override
    public int update(Integer id, App app) {
        return jdbcTemplate.update(UPDATE, app.getName(), app.getDescription(),
                app.getWeight_in_mb(),app.getCreate_date(),app.getIs_free(),
                app.getPrice_in_dollars(),app.getHas_advert(),app.getCategory_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<App> getAllFreeApps() {
        return jdbcTemplate.query(FIND_ALL_FREE_APPS,BeanPropertyRowMapper.newInstance(App.class));
    }

    @Override
    public List<App> getAppsByCategory(String name) {
        return jdbcTemplate.query(FIND_BY_CATEGORY_NAME,BeanPropertyRowMapper.newInstance(App.class),name);
    }
}
