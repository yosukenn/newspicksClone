package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.domain.Comment;

/**
 * コメントのリポジトリ
 * 
 * @author yosukenn
 *
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
