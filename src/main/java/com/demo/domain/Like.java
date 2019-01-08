package com.demo.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 「いいね」クラス。ユーザは気に入ったコメントに対して、１コメントにつき１つ「いいね」できる。
 * 
 * @author yosukenn
 *
 */
@Entity
@Table(name = "likes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {
	/** いいねID。主キー。 */
	@Id
	@GeneratedValue
	private Integer id;
	
	/** いいねをされたコメント */
	@ManyToOne(optional = false)
	@JoinColumn(name = "commentId", nullable = false)
	private Comment comment;
	
	/** いいねをしたユーザ */
	@ManyToOne(optional = false)
	@JoinColumn(name = "userId", nullable = false)
	private User user;
}
