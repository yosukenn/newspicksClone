package com.demo.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("pikcs")
public class PickController {
	@Autowired
	PickService pickService;
	
	/**
	 * @param model 画面に渡す値をModelオブジェクトの属性に設定
	 * @return 遷移する画面（ニュースを表示したトップページ）の名前
	 */
	@GetMapping
	String list(Model model) {
		List<Pick> picks = pickService.findAll();
		model.addAttribute("picks", picks);
		return "picks/index";
	}
}
