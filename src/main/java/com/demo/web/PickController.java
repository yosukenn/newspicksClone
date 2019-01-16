package com.demo.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	PickSearchForm setUpForm() {
		return new PickSearchForm();
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
	 * @param keyword ユーザが入力したキーワード
	 * @param result キーワードをバリデーションにかけた結果が格納される
	 * @param model 画面に渡す値をModelオブジェクトの属性に設定
	 * @return 検索結果を表示する画面のパス
	 */
	@GetMapping(path = "search")
	String search(@Validated PickSearchForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index(model);
		}
		model.addAttribute("keyword", form.getKeyword());
		List<Pick> picks = pickService.findByKeyword(form.getKeyword());
		model.addAttribute("picks", picks);
		return "picks/search";
	}
}
