package com.example.demolab4.controller.impl;

import com.example.demolab4.controller.DownloadController;
import com.example.demolab4.domain.App;
import com.example.demolab4.domain.Download;
import com.example.demolab4.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DownloadControllerImpl implements DownloadController {
    @Autowired
    private DownloadService downloadService;

    @Override
    public List<Download> findAll() {
        return downloadService.findAll();
    }

    @Override
    public Optional<Download> findById(Integer id) {
        return downloadService.findById(id);
    }

    @Override
    public int create(Download download) {
        return downloadService.create(download);
    }

    @Override
    public int update(Integer id, Download download) {
        return downloadService.update(id, download);
    }

    @Override
    public int delete(Integer id) {
        return downloadService.delete(id);
    }
}
