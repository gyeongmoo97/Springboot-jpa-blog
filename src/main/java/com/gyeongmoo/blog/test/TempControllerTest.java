package com.gyeongmoo.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	//http://localhost8000:/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("temphome");
		return "/home.html";
	}
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/c.png";
	}
//	  prefix: /WEB-INF/views/
//   suffix: .jsp
	//test는 /WEB-INF/views/test .jsp 경로로 찾아준다.

	@GetMapping("/temp/jsp")
	public String tempjsp() {
		return "test";
	}
	
}
