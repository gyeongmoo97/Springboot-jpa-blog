package com.gyeongmoo.blog.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@ColumnDefault("0")
	private int count ;
	
	@Lob//대용량 데이터
	private String content; //굉장히 길 수  있다. 섬머노트 라이브러리 사용할건데 <html>태그가 섞여서 디자인됨
	
	//누가 적었는지 알기위해 유저 id를 알아야한다.
	// orm에서는 외래키를 넣는게 아님
	//DB는 오브젝트를 저장할 수 없어서 FK를 사용한다.
	//자바는 오브젝트를 저장할 수 있다. FK 쓰지말고 오브젝트를 넘겨주면 된다. 근데 그러한 과정에서
	//DB는 오브젝트 저장이 불가해서 충돌이 남
//	private int userId;
	
	@ManyToOne // many = board   ,  one=user
	@JoinColumn(name="userId")
	//필드값은 userId로 만들어지고 연관관계는 manytoone으로 만들어진다
	//자동으로 User객체를 FK로 이어준다.
	private User user;
	
	@OneToMany(mappedBy = "board")//mappedBy 연관관계의 주인이 아님을 알려줌 
	//즉 FK가 아니라서 DB에 칼럼을 만들지말라는의미 JPA를 통한 Join을 위해서만 변수를 선언하기위해
	//mappedBy를 사용한다. 
	//board 는 Reply에 사용된 Board board 와 같은것이다. 
	//Reply에 Board aaa로 선언되면 mappedBy = "aaa" 로 적으면 된다.
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	
	
	
}
