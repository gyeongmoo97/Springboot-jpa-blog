package com.gyeongmoo.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HttpControllerTest {

	private static final String TAG = "HttpControllerTest";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
//		Member m = new Member(1, "rud", "an","cjd");
		Member m = new Member.MemberBuilder().email("asd").build();
		System.out.println(TAG + "getter : " + m.getId());
		m.setId(5000);
		System.out.println(TAG + "setter : " + m.getId());
//		Member m1 = new Member();
//		Member m2=new Member(0, TAG, TAG, TAG);
		return "lombok test 완료";
	}
	
	@GetMapping("/http/get")

	
		public String getTest(Member m) {
		
		return "get요청 : "+ m.getId() +","+m.getUsername()+","+m.getPassword()+","+m.getEmail() ;
	}
	//http:/localhost:8080/http/post (insert)
	
	//text/plain 을 보낸것 문자 평문을 보냈는데 다음으로는 json보내본다.
//	@PostMapping("/http/post")
//	public String postTest(@RequestBody String text) {
//		return "post요청 : "+text ;
//	}
	
	//파싱 시에는 이렇게 함.
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { 
		//requestBody 어노테이션으로 바디에 클래스를 받을 수 있음
		//스프링부터의 메시지 컨버터가 자동으로 클래스를 쿼리문으로 매핑해줌
		return "post요청 :" + m.getId() +","+m.getUsername()+","+m.getPassword()+","+m.getEmail() ;
	}
	
	//http:/localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	//http:/localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
