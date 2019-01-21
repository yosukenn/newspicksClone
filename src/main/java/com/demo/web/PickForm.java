package com.demo.web;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PickForm {
	@NotNull
	private String url;
}
