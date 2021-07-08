package com.gyeongmoo.blog.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyeongmoo.blog.model.RoleType;
import com.gyeongmoo.blog.model.User;
import com.gyeongmoo.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	//일단  userRepository는 null 이다
	//스프링이 @RestController 어노테이션을 읽어서  DummyControllerTest를 메모리에 띄워줄때
	// userRepository가 null 이다.
	
	@Autowired // 의존성 주입 DI
	//하지만  @Autowired가 출동한다면?
	// @Autowired는 UserRepository타입으로 스프링이 관리하는 객체가 있따면
	// userRepository에 쏙 넣어줌
	private UserRepository userRepository;
	
		@PostMapping("/dummy/join")
		//원래는
//		@RequestParam("username")이런식의 요청이 필요한데
		// user 에 들어가있는 멤버 변수명을 그대로 잘 따라적어주면 그 과정 생략가능
		//http://localhost:8000/blog/dummy/join
		public String join(User user) {
			System.out.println("id : "+ user.getId());
			System.out.println("username : "+ user.getUsername());
			System.out.println("password : "+user.getPassword());
			System.out.println("email : "+user.getEmail());
			System.out.println("role : "+ user.getRole());
			System.out.println("createdate : "+ user.getCreateDate());
			
			user.setRole(RoleType.USER);
			//DI를 통해서 사용할 수 있게된 방식
			userRepository.save(user);
			
			
			return "회원가입 완료";
		}
}
