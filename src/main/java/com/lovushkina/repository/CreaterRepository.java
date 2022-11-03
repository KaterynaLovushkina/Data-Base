package com.lovushkina.repository;

import com.lovushkina.domain.Creater;
import com.lovushkina.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreaterRepository extends JpaRepository<Creater, Integer> {
}
