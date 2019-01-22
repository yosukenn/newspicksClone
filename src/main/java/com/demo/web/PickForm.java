package com.demo.web;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 記事をピックするときにユーザが入力したURLがバインドされるクラス
 * @author yo-tanaka2
 *
 */
@Data
public class PickForm {
	@NotNull
	private String url;
}
