package com.demo.domain;

import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * テーマクラス。ピックした記事は該当するテーマにカテゴライズされる。
 * 複数のテーマに割り当てられる時もある。
 * 
 * @author yosukenn
 *
 */
@Entity
@Table(name = "themes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theme {
	/** テーマID */
	@Id
	@GeneratedValue
	private Integer id;
	
	/** テーマ名 */
	@Column(nullable = false, unique = true)
	private String name;
	
	/** このテーマにカテゴライズされているピックされたニュース */
	@ManyToMany
	private List<Pick> pickList;
}
