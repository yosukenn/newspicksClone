package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.domain.Like;

/**
 * 「いいね」のリポジトリ
 * 
 * @author yosukenn
 *
 */
@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {

}
