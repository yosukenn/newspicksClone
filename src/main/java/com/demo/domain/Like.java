package com.demo.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "likes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {
	@ManyToOne(optional = false)
	@JoinColumn(name = "commentId", nullable = false)
	private Comment comment;
	@ManyToOne(optional = false)
	@JoinColumn(name = "userId", nullable = false)
	private User user;
}
