package com.example.demolab4.dao.impl;

import com.example.demolab4.dao.UserDao;
import com.example.demolab4.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    private static final String FIND_ALL = "SELECT * FROM user";
    private static final String CREATE = "INSERT user(password_hash,full_name,country,email) " +
            "VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE user SET password_hash=?,full_name=?,country=?,email=? WHERE id=?";
    private static final String DELETE = "DELETE FROM user WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE id=?";

    private static final String FIND_USER_BY_APP = """
            SELECT * 
                        FROM app JOIN download_info di ON app.id = app_id
                                 JOIN download d ON di.download_id = d.id
                                 JOIN user ON d.user_id = user.id
                        WHERE app.name=?""";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public Optional<User> findById(Integer id) {
        Optional<User> user;
        try {
            user = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(User.class), id));
        } catch (EmptyResultDataAccessException e) {
            user = Optional.empty();
        }
        return user;
    }

    @Override
    public int create(User user) {
        return jdbcTemplate.update(CREATE, user.getPassword_hash(), user.getFull_name(),
                user.getCountry(), user.getEmail());
    }

    @Override
    public int update(Integer id, User user) {
        return jdbcTemplate.update(UPDATE, user.getPassword_hash(), user.getFull_name(),
                user.getCountry(), user.getEmail(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<User> getUsersByApp(String appName) {
        return jdbcTemplate.query(FIND_USER_BY_APP,
                BeanPropertyRowMapper.newInstance(User.class),appName);
    }
}
