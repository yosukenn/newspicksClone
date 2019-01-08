package com.demo.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "keywords")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String keyword;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "userId")
	private User user;
	
}
