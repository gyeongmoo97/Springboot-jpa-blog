package com.gyeongmoo.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gyeongmoo.blog.model.User;

//아래의 의미 Jpa레파지토리는 User가 관리하는 레파지토리다 User테이블의 PK는 integer 타입이다.
//DAO이다. 
// 자동으로 bean 등록이 된다. 
//@Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer>{
//crud 기능을 자체로 다 가지고 있따 JPA 레파지토리가 가지고 있거든
}
