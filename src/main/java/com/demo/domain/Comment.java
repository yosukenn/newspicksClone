package com.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.persistence.*;

/**
 * コメントクラス。ユーザは１Pick に対して 1コメントできる。
 * 
 * @author yosukenn
 *
 */
@Entity
@Table(name = "comments", indexes = @Index(columnList = "comment"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	
	/** コメントID */
	@Id
	@GeneratedValue
	private Integer id;
	
	/** コメント文 */
	@Column
	private String comment;
	
	/** ピック。ユーザがURLを入力してサイト内に取り込んだニュース記事を表す。 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "pickId")
	private Pick pick;
	
	/** コメントしたユーザ */
	@ManyToOne(optional = false)
	@JoinColumn(name = "userId")
	private User user;
	
	/** コメントにつけられた「いいね」のリスト */
	@OneToMany(mappedBy = "comment")
	private List<Like> likeList;
}
