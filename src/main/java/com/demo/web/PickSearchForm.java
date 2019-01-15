package com.demo.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PickSearchForm {
	@NotNull
	@Size(min = 1, max = 20)
	private String keyword;
}
