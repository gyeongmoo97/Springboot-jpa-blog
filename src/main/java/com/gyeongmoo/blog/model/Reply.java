package com.gyeongmoo.blog.model;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
//연관관계가 없으면 어느 사용자가 어느 보드에 작성한 댓글인지 알 수 없다.
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	//하나의 유저는 여러개의 리플을 달 수 있다.
	//리플을 누가 달았는지 알려면 user를 FK로 써야한다.
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	// 하나의 게시물에 여러개의 리플 있을 수 있다.
	//리플을 어느 게시물에 달았는지 알려면 borad를 FK로 써야한다.
	@ManyToOne
	@JoinColumn(name="boardId")
	private Board board;


	
	@CreationTimestamp
	private Timestamp createDate;
}
