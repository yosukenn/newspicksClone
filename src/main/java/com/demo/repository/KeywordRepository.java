package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.domain.Keyword;

/**
 * キーワードのリポジトリ
 * 
 * @author yosukenn
 *
 */
@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Integer> {

}
