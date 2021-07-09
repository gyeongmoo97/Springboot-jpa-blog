package com.gyeongmoo.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping({"","/"})
	public String index() {
//	      prefix: /WEB-INF/views/
//	      suffix: .jsp
//		 이렇게 된다 . /WEB-INF/views/index.jsp
		return "index";
	}
}
