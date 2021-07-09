package com.gyeongmoo.blog.test;


import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gyeongmoo.blog.model.RoleType;
import com.gyeongmoo.blog.model.User;
import com.gyeongmoo.blog.repository.UserRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

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
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "삭제에 실패했습니다.";
		}
		
		
		return "삭제되었습니다.  ID : "+id;
	}
	
	//email, PW update
	@Transactional // 종료시 commit
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser ) {
		System.out.println("id : "+ id);
		System.out.println("password: "+ requestUser.getPassword());
		System.out.println("email : "+ requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("수정 실패" );
			}
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		return user;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	//*******************pageable 정보까지 같이 받을 때 
//	@GetMapping("/dummy/user")
//	public Page<User> pageList(@PageableDefault(size = 2,sort = "id", direction = org.springframework.data.domain.Sort.Direction.DESC) Pageable pageable ){
//		Page<User> users = userRepository.findAll(pageable);
//		return users;
//	}
	//************ 컨텐츠만 필요할 때
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size = 2,sort = "id", direction = org.springframework.data.domain.Sort.Direction.DESC) Pageable pageable ){
		Page<User> pagingUsers = userRepository.findAll(pageable);
		
		List<User> users = pagingUsers.getContent(); 
		return users;
	}
	
	@GetMapping("/dummy/user/{id2}")
	public User detail(@PathVariable int id2) {
		User user = userRepository.findById(id2).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당유저는 없습니다 ID : " + id2);
			}
		});
		return user;
	}
	
//		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>("해당사용자 존재하지 않음") {
//		@Override
//		public IllegalArgumentException get() {
//			// TODO Auto-generated method stub
//				return new  IllegalArgumentException("해당유저는 존재하지 않음 id :"+ id);
//			}
//		
//		});
//		return  user;
//	}
	
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
