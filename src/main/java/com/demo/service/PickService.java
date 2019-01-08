package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.Pick;
import com.demo.repository.PickRepository;

/**
 * ピック（ニュース）のサービスクラス。
 * 
 * @author yosukenn
 *
 */
@Service
@Transactional
public class PickService {
	/**
	 * DIコンテナからピックのリポジトリクラスのインスタンスをインジェクション
	 */
	@Autowired
	PickRepository pickRepository;
	
	/**
	 * ピック（ニュース）を全件取得するメソッド
	 * @return DBに登録されているピックの全件リスト
	 */
	public List<Pick> findAll() {
		return pickRepository.findAll();
	}
}
