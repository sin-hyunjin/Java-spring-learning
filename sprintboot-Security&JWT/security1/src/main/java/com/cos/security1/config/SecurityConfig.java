package com.cos.security1.config;


import com.cos.security1.config.oauth.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



/**
 * Spring Security 6.1.0부터는 메서드 체이닝의 사용을 지양하고 람다식을 통해 함수형으로 설정하게 지향
 */
@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.
@EnableMethodSecurity(securedEnabled = true , prePostEnabled = true) // secured 어노테이션 활성화, preAuthorize 어노테이션 활성화
public class SecurityConfig {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    /** 해당 메서드의 리턴되는 오브젝트를 ioc로 등록해준다 */
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/user/**").authenticated() // 인증만 되면 들어갈수 있는 주소
                                .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN") // 권한이 필요
                                .requestMatchers("/admin/**").hasRole("ADMIN") // 권한이 필요
                                .anyRequest().permitAll()
                );

        // 권한이 없을 때 로그인페이지로 이동
        http
                .formLogin((formLogin) ->
                        formLogin
                                .loginPage("/loginForm")
                                .loginProcessingUrl("/login")// login 주소가 호출되면 security가 낚아채서 대신 로그인을 진행해줌
//                                .usernameParameter("email")
                                .defaultSuccessUrl("/") // 로그인이 성공되면 메인페이지로 이동
                );

        /** // 구글 로그인이 완료된 뒤의 후처리가 필요
         *  1. 코드받기(인증),
         *  2. 엑세스토큰(권한) ,
         *  3. 사용자 프로필 정보를 가져옴,
         *  4-1. 그 정보를 토대로 회원가입을 자동 진행
         *  4-2. (이메일, 전화번호, 이름, 아이디) 쇼핑몰을 한다면? -> 집주소가 필요 (추가적인 구성이 필요 )
         *
         *  TIP.코드X (엑세스토큰 + 사용자프로필정보 O)
         */
        http
                .oauth2Login((oauth2) ->
                        oauth2
                                .loginPage("/loginForm")
                                .userInfoEndpoint(userInfoEndpointConfig ->
                                        userInfoEndpointConfig.
                                                userService(principalOauth2UserService))

                );


        return http.build();
    }

    }



