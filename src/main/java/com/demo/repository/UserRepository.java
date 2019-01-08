package com.demo.repository;

import com.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ユーザのリポジトリ
 * 
 * @author yosukenn
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
