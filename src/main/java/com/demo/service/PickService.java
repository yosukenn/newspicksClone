package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.Pick;
import com.demo.repository.PickRepository;

/**
 * ピック（ニュース）のサービスクラス。
 * 機能実装するごとに必要なメソッドを追記していく。
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
	
	/**
	 * ピックをキーワードから検索する業務ロジック
	 * @param keyword ユーザがフォームに入力したキーワード
	 * @return DBから取得した、キーワードをタイトル(title)、本文(body)に含むピックのリスト
	 */
	public List<Pick> findByKeyword(String keyword) {
		return pickRepository.findByKeyword(keyword);
	}
}
