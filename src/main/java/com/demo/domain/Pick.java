package com.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "picks", indexes = @Index(columnList = "title, body"))
@Data
@NoArgsConstructor	// （仮）
@AllArgsConstructor	// （仮）
public class Pick {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false, unique = true)
	private String url;
	@Column(nullable = false)
	private String imageUrl;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String body;
	@Column(nullable = false)
	private String source;
	
	@OneToMany(mappedBy = "pick")
	private List<Comment> commentList;
}
