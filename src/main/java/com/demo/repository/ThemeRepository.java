package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.domain.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {

}
