package com.demo.domain;

import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザクラス。
 * ニュースをピックするが、キュレートされたピックにはピックしたユーザの情報は紐付かない。
 * １ピックに対して、１コメントできる
 * 気に入った１コメントに対して、１いいねできる。
 * 任意のキーワードを複数登録できる。
 * 
 * @author yosukenn
 *
 */
@Entity
@Table(name = "users", indexes = @Index(columnList = "firstName, lastName"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	/** ユーザID */
	@Id
	@GeneratedValue
	private Integer id;
	
	/** 名 */
	@Column(nullable = false)
	private String firstName;
	
	/** 氏 */
	@Column(nullable = false)
	private String lastName;
	
	/** 肩書き/会社名/役職など */
	@Column
	private String position;
	
	/** 自己紹介文 */
	@Column
	private String profile;
	
	/** サムネイルのURL。余裕があれば画像アップロードできれば */
	@Column
	private String imageUrl;
	
	/** このユーザがしたコメント */
	@OneToMany(mappedBy = "user")
	private List<Comment> commentList;
	
	/** このユーザがした「いいね」 */
	@OneToMany(mappedBy = "user")
	private List<Like> likeList;
	
	/** このユーザが登録したキーワード */
	@OneToMany(mappedBy = "user")
	private List<Keyword> keywordList;
}
