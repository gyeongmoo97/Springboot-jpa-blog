package com.gyeongmoo.blog.model;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

//테이블을 위해서 엔티티 어노테이션을 붙혀야 한다.
@Entity // User클래스가 자동으로 MySQL에 생성된다.

public class User {
	@Id //primary Key 인것을 알려주기 위함
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//프로젝트에서 연결된 DB의 넘버링전략을 따라간다.
	
	
	private int id; // 시퀀스로 auto_increment 하는 전략 사용
	
	@Column(nullable=false, length = 100)
	private String username; // ID
	
	@Column(nullable = false, length = 100)
	private String password; // 
	@Column(nullable = false, length = 100)
	private String email; // 
	
	@ColumnDefault("'user'")
	@Column(nullable = false, length = 77)
	private String role; //
	//이넘을 쓰는게 좋다. 
	
	@CreationTimestamp // 이 어노테이션을 사용하면 시간이 자동으로 입력됨
	private Timestamp createDate; // 생성일자
	
}
