package com.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "comments", indexes = @Index(columnList = "comments"))
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
}
