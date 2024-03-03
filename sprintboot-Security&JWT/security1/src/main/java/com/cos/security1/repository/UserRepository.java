package com.cos.security1.repository;

import com.cos.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD 함수를 JpaRepository가 들고 있음
 * @Repository라는 어노테이션이 없어도 IOC가 된다. -> 이유는 JpaRepository를 상속받기 떄문
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /** findBy규칙 -> Username 문법
     * select * from user where username = ?
     * */
    User findByUsername(String username); //Jpa Query method 참고
}

