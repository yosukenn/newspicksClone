package com.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.persistence.*;

/**
 * ピッククラス。ユーザがキュレーションしたニュース記事を表す。
 * 
 * @author yosukenn
 *
 */
@Entity
@Table(name = "picks", indexes = @Index(columnList = "title, body"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pick {
	/** ピックID */
	@Id
	@GeneratedValue
	private Integer id;
	
	/** ピックした記事のURL */
	@Column(nullable = false, unique = true)
	private String url;
	
	/** ピックした記事の画像のURL */
	@Column(nullable = false)
	private String imageUrl;
	
	/** ピックした記事のタイトル */
	@Column(nullable = false)
	private String title;
	
	/** ピックした記事の本文 */
	@Column(nullable = false)
	private String body;
	
	/** ピックした記事を扱っているニュースサイト名 */
	@Column(nullable = false)
	private String source;
	
	/** ピックした記事に対して行われているコメント */
	@OneToMany(mappedBy = "pick")
	private List<Comment> commentList;
	
	/** ピックした記事がカテゴライズされているテーマ（ジャンル） */
	@ManyToMany(mappedBy = "pickList")
	private List<Theme> themeList;
}
