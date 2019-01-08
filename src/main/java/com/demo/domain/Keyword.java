package com.demo.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * キーワードクラス。１ユーザは任意のキーワードを複数登録できる。
 * 
 * @author yosukenn
 *
 */
@Entity
@Table(name = "keywords")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {
	
	/** キーワードID */
	@Id
	@GeneratedValue
	private Integer id;
	
	/** キーワード */
	@Column(nullable = false)
	private String keyword;
	
	/** このキーワードを登録したユーザ */
	@ManyToOne(optional = false)
	@JoinColumn(name = "userId")
	private User user;
	
}
