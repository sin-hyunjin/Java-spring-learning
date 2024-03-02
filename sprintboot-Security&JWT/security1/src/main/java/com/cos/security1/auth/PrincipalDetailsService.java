package com.cos.security1.auth;

import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * 1. 시큐리티 설정에서 .loginProcessingUrl("/login")
 * .login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어있는 loadUserByUserName 함수가 실행
 * */
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /** paramiter를 바꾸고 싶다면 String username securityconfig에서 .usernameParameter("email")로 설정을 해줘야함
     * Security session(내부 Authentication(내부 UserDetails))*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username = " + username);
        User userEntity = userRepository.findByUsername(username);
        if(userEntity != null) {
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
