package com.gyeongmoo.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello Spring boot</h1>";
	}
}
