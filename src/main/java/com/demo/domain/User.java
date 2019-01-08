package com.demo.domain;

import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", indexes = @Index(columnList = "firstName, lastName"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column
	private String position;
	
	@Column
	private String profile;
	
	@Column
	private String imageUrl;
	
	@OneToMany(mappedBy = "user")
	private List<Comment> commentList;
	
	@OneToMany(mappedBy = "user")
	private List<Like> likeList;
	
	@OneToMany(mappedBy = "user")
	private List<Keyword> keywordList;
}
