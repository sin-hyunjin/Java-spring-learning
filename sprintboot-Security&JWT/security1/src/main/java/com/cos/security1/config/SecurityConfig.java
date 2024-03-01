package com.cos.security1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.
public class SecurityConfig {
    /**
     * Spring Security 6.1.0부터는 메서드 체이닝의 사용을 지양하고 람다식을 통해 함수형으로 설정하게 지향
     */

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
                                .requestMatchers("/user/**").authenticated() // 인증이 필요
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
                                .defaultSuccessUrl("/") // 로그인이 성공되면 메인페이지로 이동
                );

        return http.build();
    }

    }



