package com.gyeongmoo.blog.model;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//테이블을 위해서 엔티티 어노테이션을 붙혀야 한다.
@Entity // User클래스가 자동으로 MySQL에 생성된다.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@DynamicInsert // null값인 칼럼을 제외시키고 insert 해주는 어노테이션임
public class User {
	@Id //primary Key 인것을 알려주기 위함
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//프로젝트에서 연결된 DB의 넘버링전략을 따라간다.
	
	
	private int id; // 시퀀스로 auto_increment 하는 전략 사용
	// unique = true 를통해 유일한 값가지게 할 수 있다.
	@Column(nullable=false, length = 100, unique = true)
	private String username; // ID
	
	@Column(nullable = false, length = 100)
	private String password; // 
	@Column(nullable = false, length = 100)
	private String email; // 
	
//	@ColumnDefault("'user'")
	//DB는 RoleType이라는게 없어서 따로 알려줘야함
	@Enumerated(EnumType.STRING)
	private RoleType role; //
	//이넘을 쓰는게 좋다. 
	
	@CreationTimestamp // 이 어노테이션을 사용하면 시간이 자동으로 입력됨
	private Timestamp createDate; // 생성일자
	
}
