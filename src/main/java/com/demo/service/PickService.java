package com.demo.service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		return pickRepository.findAll(
				new Sort(Sort.Direction.DESC, "id"));
	}
	
	/**
	 * ピックをキーワードから検索する業務ロジック
	 * @param keyword ユーザがフォームに入力したキーワード
	 * @return DBから取得した、キーワードをタイトル(title)、本文(body)に含むピックのリスト
	 */
	public List<Pick> findByKeyword(String keyword) {
		return pickRepository.findByKeyword(keyword);
	}
	
	/**
	 * 入力されたURLからピックを作成、保存する業務ロジック
	 * @param url ユーザが入力したニュース記事のURL
	 * @return 作成したピック
	 * @throws IOException
	 */
	public Pick create(String url) throws IOException {
		Pick pick = getNewsInfo(url);
		System.out.println(pick);
		return pickRepository.save(pick);
	}
	
	/**
	 * URLからニュース記事の情報をスクレイピングしてくるメソッド
	 * @param url ユーザが入力したURL
	 * @return スクレイピングした記事情報から生成した記事オブジェクト
	 * @throws IOException
	 */
	private Pick getNewsInfo(String url) throws IOException {
		// 渡されたURLのHTML情報を取得
		Document document = Jsoup.connect(url).get();
		
		// 画像ソースの取得
		String imageUrl;
		if (document.getElementsByAttributeValue("property", "og:image") != null) {
			Elements imgElements = document.getElementsByAttributeValue("property", "og:image");
			imageUrl = imgElements.first().attr("content");
		} else {
			imageUrl = "https://lh3.googleusercontent.com/VVhNlcQA_r1FP-T09tiSPdASiiBAYsQ7jw0StynJmoIzqy1BxteCOJtlh_fXzl-_JCUNj0inwj-MM7-EYgeR3ObcihckA-FjK_CUrmGzIsEGYJfiyBhOH4JDftzEfPEFxFm-3ycY4lQ=w853-h570-no";
		}
		
		// タイトルの取得
		String title;
		if ( document.getElementsByAttributeValue("property", "og:title") != null) {
			Elements titleElements = document.getElementsByAttributeValue("property", "og:title");
			title = titleElements.attr("content");
		} else if ( document.select("h1") != null ) {
			Elements titleElements = document.select("h1");
			title = titleElements.first().text();
		} else if ( document.select("h2") != null ) {
			Elements titleElements = document.select("h2");
			title = titleElements.first().text();
		} else {
			title = "記事タイトルを取得できませんでした。";
		}
		
		Elements bodyElements = document.select("p");
		String body;
		if (bodyElements != null) {
			body = bodyElements.first().text();
		} else {
			body = "本文の取得に失敗しました。";
		}
		
		// ソース
		Elements sourceElements = document.getElementsByAttributeValue("property", "og:site_name");
		String source;
		if (sourceElements != null) {
			source = sourceElements.first().attr("content");
		} else {
			source = url;
		}
		
		Pick pick = new Pick();
		pick.setUrl(url);
		pick.setImageUrl(imageUrl);
		pick.setTitle(title);
		pick.setBody(body);
		pick.setSource(source);
		
		return pick;
	}
}
