package com.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	@Query("SELECT DISTINCT p FROM Pick p where p.title like %:keyword% OR p.body like %:keyword% ORDER BY p.id DESC")
	List<Pick> findByKeyword(@Param("keyword") String keyword);
}
