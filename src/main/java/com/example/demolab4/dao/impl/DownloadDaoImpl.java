package com.example.demolab4.dao.impl;

import com.example.demolab4.dao.DownloadDao;
import com.example.demolab4.domain.Download;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DownloadDaoImpl implements DownloadDao {

    private static final String FIND_ALL = "SELECT * FROM download";
    private static final String CREATE = "INSERT download(amount, total_price, user_id)VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE download SET amount=?,total_price=?,user_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM download WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM download WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Download> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Download.class));
    }


    @Override
    public Optional<Download> findById(Integer id) {
        Optional<Download> download;
        try {
            download = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Download.class), id));
        } catch (EmptyResultDataAccessException e) {
            download = Optional.empty();
        }
        return download;
    }

    @Override
    public int create(Download download) {
        return jdbcTemplate.update(CREATE, download.getAmount(), download.getTotal_price(), download.getUser_id());
    }

    @Override
    public int update(Integer id, Download download) {
        return jdbcTemplate.update(UPDATE, download.getAmount(), download.getTotal_price(), download.getUser_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
