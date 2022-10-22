package com.example.demolab4.service.impl;

import com.example.demolab4.dao.DownloadDao;
import com.example.demolab4.domain.Download;
import com.example.demolab4.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private DownloadDao downloadDao;

    @Override
    public List<Download> findAll() {
        return downloadDao.findAll();
    }

    @Override
    public Optional<Download> findById(Integer id) {
        return downloadDao.findById(id);
    }

    @Override
    public int create(Download download) {
        return downloadDao.create(download);
    }

    @Override
    public int update(Integer id, Download download) {
        return downloadDao.update(id,download);
    }

    @Override
    public int delete(Integer id) {
        return downloadDao.delete(id);
    }
}
