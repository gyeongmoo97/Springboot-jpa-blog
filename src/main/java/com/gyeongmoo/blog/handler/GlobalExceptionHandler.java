package com.gyeongmoo.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // 모든 exception 발생시 이 클래스로 연결된다.
@RestController
public class GlobalExceptionHandler {
	
	//excption 이 처리되었을 때 이 함수를 실행시킬 예정이다.
	@ExceptionHandler(value = IllegalArgumentException.class)
	public String handleAurgmentExcption(IllegalArgumentException e) {
		return "<h1>"+e.getMessage()+ "</h1>";
	}
	
	// 모든 excption 을 가지고 있는 부모클래스인 exception 을 사용하면 
	//모든 에러 받기 가능 대신 에러 구분은 안됨
	@ExceptionHandler(value = Exception.class)
	public String allExcption(Exception e) {
		return "<h1>"+e.getMessage()+ "</h1>";
	}
	
	
}
