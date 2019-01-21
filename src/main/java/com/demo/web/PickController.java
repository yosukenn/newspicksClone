package com.demo.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.demo.domain.Pick;
import com.demo.service.PickService;

/**
 * ピックに関するリクエストを受けるエンドポイント
 * 
 * @author yosukenn
 *
 */
@Controller
@RequestMapping("picks")
public class PickController {
	@Autowired
	PickService pickService;
	
	/**
	 * 検索フォームクラスを初期化するメソッド。返り値を自動的にModel に追加する
	 * @return 検索フォームのパラメータをバインドする PickSearchForm クラス
	 */
	@ModelAttribute
	PickSearchForm setUpSearchForm() {
		return new PickSearchForm();
	}
	
	/**
	 * ピックフォームを初期化するメソッド。
	 * @return 入力した、ピックしたいURLをバインドする PickForm クラス
	 */
	@ModelAttribute
	PickForm serUpFrom() {
		return new PickForm();
	}
	
	/**
	 * トップページを表示するメソッド。
	 * @param model 画面に渡す値をModelオブジェクトの属性に設定
	 * @return 遷移する画面（ニュースを表示したトップページ）の名前
	 */
	@GetMapping
	String index(Model model) {
		List<Pick> picks = pickService.findAll();
		model.addAttribute("picks", picks);
		return "picks/index";
	}
	
	/**
	 * ユーザが入力したキーワードから検索画面を表示させるメソッド。
	 * @param form ユーザが入力したキーワード
	 * @param result キーワードをバリデーションにかけた結果が格納される
	 * @param model 画面に渡す値をModelオブジェクトの属性に設定
	 * @return 検索結果を表示する画面のパス
	 */
	@GetMapping("search")
	String search(@Validated PickSearchForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index(model);
		}
		model.addAttribute("keyword", form.getKeyword());
		List<Pick> picks = pickService.findByKeyword(form.getKeyword());
		model.addAttribute("picks", picks);
		return "picks/search";
	}
	
	/**
	 * ピックしたい記事のURLをユーザーが送信した時の処理をマッピング。
	 * 記事作成後、トップにリダイレクトさせる。
	 * @param form ユーザーが入力した「記事のURL」
	 * @param result URLにバリデーションした結果が格納される。
	 * @param model 画面に渡す値を格納するが、今回は不要？
	 * @return トップにリダイレクトするパス
	 */
	@PostMapping("create")
	String create(@Validated PickForm form, BindingResult result, Model model) throws IOException {
		if (result.hasErrors()) {
			return index(model);
		}
		pickService.create(form.getUrl());
		return "redirect:/picks";
	}
	
	/**
	 * IOException の例外ハンドラー
	 * Ajax でフォームにエラーメッセージを表示したいが、暫定的な処置としてJSONを返す
	 * @param e エラーオブジェクト
	 * @return エラー時のJSONメッセージ
	 */
	@ExceptionHandler(IOException.class)
	public ResponseEntity<String> handleIOException(IOException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
