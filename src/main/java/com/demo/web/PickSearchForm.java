package com.demo.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 検索フォームのパラメータがバインドされるクラス
 * @author yo-tanaka2
 *
 */
@Data
public class PickSearchForm {
	@NotNull
	@Size(min = 1, max = 20)
	private String keyword;
}
