package com.example.demo.common.authority

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider
) {
    // SecurityFilterChain을 정의하는 빈 메서드
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            // HTTP Basic 인증 비활성화
            .httpBasic { it.disable() }
            // CSRF(Cross-Site Request Forgery) 비활성화
            .csrf { it.disable() }
            // 세션 관리 정책을 STATELESS로 설정하여 세션을 사용하지 않음
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            // 특정 API 엔드포인트에 대한 접근 권한 설정
            .authorizeHttpRequests {
                it.requestMatchers("/api/member/signup", "/api/member/login").anonymous()
                    .requestMatchers("/api/member/info/**").hasRole("MEMBER")
                    .anyRequest().permitAll() // 나머지 요청은 모두 허용
            }
            // JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter 앞에 추가
            .addFilterBefore(
                JwtAuthenticationFilter(jwtTokenProvider),
                UsernamePasswordAuthenticationFilter::class.java
            )

        // SecurityFilterChain을 빌드하여 반환
        return http.build()
    }

    // PasswordEncoder 빈 등록
    @Bean
    fun passwordEncoder(): PasswordEncoder =
        PasswordEncoderFactories.createDelegatingPasswordEncoder()
}
