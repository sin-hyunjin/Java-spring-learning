# 스프링 시큐리티 기본 V1

- WebSecurityConfigurerAdapter 6.0이상 버전에서 사용 x
- 람다식 문법 전환

### MySQL DB 및 사용자 생성

```sql
create user 'cos'@'%' identified by 'cos1234';
GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
create database security;
use security;
```

### SecurityConfig.java 권한 설정 방법

```java
// protected void configure(HttpSecurity http) 함수 내부에 권한 설정법
.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
```

### 컨트롤러의 함수에 직접 권한 설정 하는 방법

```java
// 특정 주소 접근시 권한 및 인증을 위한 어노테이션 활성화 SecurityConfig.java에 설정
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)

// 컨트롤러에 어노테이션 거는 법
@PostAuthorize("hasRole('ROLE_MANAGER')")
@PreAuthorize("hasRole('ROLE_MANAGER')")
@Secured("ROLE_MANAGER")
```

# 1. 시큐리티 실행

**로그인창**
![img.png](img%2Fimg.png)

**시큐리티 비밀번호 콘솔창**
![img_1.png](img%2Fimg_1.png)

**로그아웃 주소**
![img_2.png](img%2Fimg_2.png)

- Security에 기본적으로 제공되는 주소값이다

# [Spring Boot] WebSecurityConfigurerAdapter 지원 중단

- [스프링 부트 공식 사이트](https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter/) 참고해서 작성

- [인프런 강의](https://www.inflearn.com/course/lecture?courseSlug=%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0&unitId=97761)를 따라가는 중 초반 시큐리티 버전 업그레이드로 오류 발생
- Spring boot 3.1.0, Spring Security 6.1.0 임 . Spring Security 6.1.0부터는 메서드 체이닝의 사용을 지양하고 람다식을 통해 함수형으로 설정하게 지향하고 있다고함

### [변경 전: SecurityConfig.java]

```java
package kr.co.ch08.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // WebSecurityConfigurerAdapter 상속 받아서 하는 씨큐리티 설정은 Deprecated 됨 -> filterChain 방식 권장
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    // 인가(접근권한) 설정 (index : 모든 링크(사용자)에 대해 허용을 해 준 상태, 권한관리필터)
    http.authorizeHttpRequests().antMatchers("/").permitAll();
    // admin 하위의 모든 자원 -> "ADMIN"에게 부여
    http.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN");
    // member 하위의 모든 자원 -> "ADMIN", "MEMBER" 에게 부여
    http.authorizeHttpRequests().antMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER");
    // GUEST는 무권한 -> 생략
    // loginSuccess 접근 -> "ADMIN"만 접근 허용
    http.authorizeHttpRequests().antMatchers("/user2/loginSuccess").hasAnyRole("3", "4", "5");

    // 사이트 위변조 요청 방지
    http.csrf().disable();

    // 로그인 설정
    http.formLogin()
    .loginPage("/user2/login")
    .defaultSuccessUrl("/user2/loginSuccess")
    .failureUrl("/user2/login?success=100")
    .usernameParameter("uid")
    .passwordParameter("pass");

    // 로그아웃 설정
    http.logout()
    .invalidateHttpSession(true)
    .logoutRequestMatcher(new AntPathRequestMatcher("/user2/logout"))
    .logoutSuccessUrl("/user2/login?success=200");
	}

	@Autowired
	private SecurityUserService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 로그인 인증처리 서비스 등록 (기본 SHA2)
		//auth.userDetailsService(service).passwordEncoder(new MessageDigestPasswordEncoder("SHA-256"));

		// 로그인 인증처리 서비스 등록 (BcryptPassword)
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}

}
```

### [변경 후: SecurityConfigration.java]

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
            .csrf((csrfConfig) ->
                    csrfConfig.disable()
            )
            .headers((headerConfig) ->
                    headerConfig.frameOptions(frameOptionsConfig ->
                            frameOptionsConfig.disable()
                    )
            )
            .authorizeHttpRequests((authorizeRequests) ->
                    authorizeRequests
                            .requestMatchers(PathRequest.toH2Console()).permitAll()
                            .requestMatchers("/", "/login/**").permitAll()
                            .requestMatchers("/posts/**", "/api/v1/posts/**").hasRole(Role.USER.name())
                            .requestMatchers("/admins/**", "/api/v1/admins/**").hasRole(Role.ADMIN.name())
                            .anyRequest().authenticated()
            )
            .exceptionHandling((exceptionConfig) ->
                    exceptionConfig.authenticationEntryPoint(unauthorizedEntryPoint).accessDeniedHandler(accessDeniedHandler)
            )
            .formLogin((formLogin) ->
                    formLogin
                            .loginPage("/login/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .loginProcessingUrl("/login/login-proc")
                            .defaultSuccessUrl("/", true)
            )
            .logout((logoutConfig) ->
                    logoutConfig.logoutSuccessUrl("/")
            )
            .userDetailsService(myUserDetailsService);

    return http.build();
}
```

# 구글 로그인

### 1. Google API CONSOLE 접속

### 2. 프로젝트 생성

![alt text](image.png)

### 3.OAuth 동의 화면 설정

### 4. 사용자 인증 정보 접속

- 사용자 인증 정보 만들기
  ![alt text](image-2.png)

- oauth 클라이언트 ID 만들기
  ![alt text](image-3.png)

  - OAUTH 라이브러리를 쓰면 주소는 고정이다
  - contoller 주소는 따로 필요없다
