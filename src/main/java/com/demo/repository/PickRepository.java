package com.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.domain.Pick;

/**
 * ピック（ニュース）のリポジトリ
 * 
 * @author yosukenn
 *
 */
@Repository
public interface PickRepository extends JpaRepository<Pick, Integer> {

}
