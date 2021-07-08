package com.gyeongmoo.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data//갯터 + 셋터
@AllArgsConstructor//전체 생성자
@NoArgsConstructor//빈 생성자

@Builder
public class Member {
	private int id;
	private String password;
	private String username;
	private String email;
	
	
//	private String
//	
//	public Member(int id, String password, String username, String email) {
//	this.id = id;
//	this.password = password;
//	this.username = username;
//	this.email = email;
//}
//	
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
//	
	
//	Member()
//	public int getId() {
//		return id;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public String getEmail() {
//		return email;
//	}
}
