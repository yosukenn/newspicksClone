package com.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "comments", indexes = @Index(columnList = "comment"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String comment;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "pickId")
	private Pick pick;
	@ManyToOne(optional = false)
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToMany(mappedBy = "comment")
	private List<Like> likeList;
}
