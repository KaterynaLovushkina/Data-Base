package com.lovushkina.service;

import com.lovushkina.domain.App;
import com.lovushkina.domain.Download;
import com.lovushkina.domain.Download;

import java.util.List;

public interface DownloadService extends GeneralService<Download,Integer>{
    Download create(Download download, Integer userId);
    void update(Integer downloadId, Download download, Integer userId);
    List<App> getAppsByDownloadId(Integer id);
}
