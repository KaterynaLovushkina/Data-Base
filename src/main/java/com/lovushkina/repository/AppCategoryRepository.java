package com.lovushkina.repository;

import com.lovushkina.domain.AppCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppCategoryRepository extends JpaRepository<AppCategory, Integer> {
}
