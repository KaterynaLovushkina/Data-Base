package com.lovushkina.repository;

import com.lovushkina.domain.Download;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadRepository extends JpaRepository<Download, Integer> {
}
