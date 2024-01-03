# 목차 
- [1.프로젝트 환경 설정](#1-프로젝트-환경-설정)

- [2.스프링 웹 개발 기초](#2-스프링-웹-개발-기초-)
  - [/정적 컨텐츠](#정적-컨텐츠-)
  - [/MVC와 템플릿 엔진](#mvc와-템플릿-엔진-)
  - [/API (json)](#api)
- [3. 회원 관리 예제 - 백엔드 개발](#3-회원-관리-예제---백엔드-개발-)
  - [/비즈니스 요구사항 정리](#비즈니스-요구사항-정리-)
  - [/회원 도메인과 리포지토리 만들기]()
  - [/회원 리포지토리 테스트 케이스 작성]()
  - [/회원 서비스 개발]()
  - [/회원 서비스 테스트]()
- [4. 스프링 빈과 의존관계](#4-스프링-빈과-의존관계)
  - [/컴포넌트 스캔과 자동 의존관계 설정]()
  - [/자바 코드로 직접 스프링 빈 등록하기]()
- [5. 회원 관리 예제 - 웹MVC개발](#회원-관리-예제---웹-mvc-개발)
  - [[/회원 웹 기능 - 홈 화면 추가]]()
  - [[/회원 웹 기능 - 등록]]()
  - [[/회원 웹 기능 - 조회]]()
# 1. 프로젝트 환경 설정

### 프로젝트 생성

**사전 준비물**

- **Java 17 이상 설치**
- IDE: IntelliJ 또는 Eclipse 설치

>**스프링 부트 스타터 사이트로 이동해서 스프링 프로젝트 생성**
https://start.spring.io

<br>

### 라이브러리 

**스프링 부트 라이브러리** 
- spring-boot-starter-web
    - spring-boot-starter-tomcat: 톰캣 (웹서버)
    - spring-webmvc: 스프링 웹 MVC 
- spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View) 
- spring-boot-starter(공통): 스프링 부트 + 스프링 코어 + 로깅
    - spring-boot 
        - spring-core
    - spring-boot-starter-logging 
        - logback, slf4j
      
**테스트 라이브러리** 
- spring-boot-starter-test
    - junit: 테스트 프레임워크
    - mockito: 목 라이브러리
    - assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리 
    - spring-test: 스프링 통합 테스트 지원

**thymeleaf 템플릿 엔진**
- thymeleaf 공식 사이트: https://www.thymeleaf.org/
- 스프링 공식 튜토리얼: https://spring.io/guides/gs/serving-web-content/
- 스프링부트 메뉴얼: https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/ spring-boot-features.html#boot-features-spring-mvc-template-engines

<br>

### 템플릿 엔진 동작확인 



- 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( `viewResolver` )가 화면을 찾아서 처리한다. 
    - 스프링 부트 템플릿엔진 기본 viewName 매핑
    - `resources:templates/` +{ViewName}+ `.html`

> `spring-boot-devtools` 라이브러리를 추가하면, `html` 파일을 컴파일만 해주면 서버 재시작 없이 View 파일 변경이 가능하다.

<br>

### 빌드하고 실행하기

콘솔로 이동
1. `./gradlew build`
2. `cd build/libs`
3. `ls -arlth`
3. `java -jar hello-spring-0.0.1-SNAPSHOT.jar`
4. 실행확인

<hr>

# 2. 스프링 웹 개발 기초 
- [/정적 컨텐츠](#정적-컨텐츠-)
- [/MVC와 템플릿 엔진](#mvc와-템플릿-엔진-)
- [/API (json)](#api)

### 정적 컨텐츠 

**실행**
http://localhost:8080/hello-static.html


1. 웹브라우저에 접속
2. 톰캣 서버가 요청을 받고 컨트롤러 쪽에 hello-static이 있는지 찾아봄
3. 컨트롤러가 우선순위를 갖고 없다면 static에서 hello-static.html를 찾고 있으면 반환

### MVC와 템플릿 엔진 
- MVC: Model,View,Controller


  **실행**
  http://localhost:8080/hello-mvc?name=spring

**Controller**
```java
 @GetMapping("hell-mvc")
    public String hellomvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
```
**View**


```html 
resourse/templates/hello-template.html

<html xmlns:th="http://www.thymeleaf.org">
<body>
<p th:text="'hello ' + ${name}">hello! empty</p>
</body>
</html>
```

### API

```java
@GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // HelloController.Hello 라고 할수 있음 자바에서 정식으로 지원하는 문법
    static class Hello {
        // key는 name
        private String name;

        // 꺼낼 떄
        public String getName() {
            return name;
        }
        // 넣을 떄
        public void setName(String name) {
            this.name = name;
        }
```
-`@ResponseBody` 를 사용하고, 객체를 반환하면 객체가 JSON으로 변환됨

**@ResponseBody 사용 원리**

![img.png](img%2Fimg.png)

- @ResponseBody` 를 사용
  - HTTP의 BODY에 문자 내용을 직접 반환
  - `viewResolver` 대신에 `HttpMessageConverter` 가 동작
  - 기본 문자처리: `StringHttpMessageConverter`
  - 기본 객체처리: `MappingJackson2HttpMessageConverter`
  - byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음

<hr>

# 3. 회원 관리 예제 - 백엔드 개발 

- [/비즈니스 요구사항 정리](#비즈니스-요구사항-정리-)
- [/회원 도메인과 리포지토리 만들기]()
- [/회원 리포지토리 테스트 케이스 작성]()
- [/회원 서비스 개발]()
- [/회원 서비스 테스트]()

### 비즈니스 요구사항 정리 
- 데이터 : 회원 id, 이름
- 기능 : 회원 등록, 조희
- 아직 데이터 저장소 선정 x 

**일반적인 웹 애플리케이션 계층 구조**

![img2.png](img%2Fimg2.png)

- 컨트롤러: 웹 MVC의 컨트롤러 역할
- 서비스: 핵심 비즈니스 로직 구현
- 리포지토리: 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
- 도메인: 비즈니스 도메인 객체, 예) 회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리됨

### 회원 리포지토리 테스트 케이스 작성

>개발한 기능을 실행해서 테스트 할 때 자바의 main 메서드를 통해서 실행하거나, 웹 애플리케이션의 컨트롤러를 통해 서 해당 기능을 실행한다. 이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행하기 어렵고 여러 테스트를 한번 에 실행하기 어렵다는 단점이 있다. 자바는 JUnit이라는 프레임워크로 테스트를 실행해서 이러한 문제를 해결함


# 4. 스프링 빈과 의존관계

- [[/컴포넌트 스캔과 자동 의존관계 설정]]
- [[/자바 코드로 직접 스프링 빈 등록하기]]

**회원 컨트롤러에 의존관계 추가**

```java
package hello.hellospring.controller;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class MemberController {
     private final MemberService memberService;
     @Autowired
     public MemberController(MemberService memberService) {
         this.memberService = memberService;
     }
}
```

- 생성자에 `@Autowired` 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다. 이렇게 객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입이라 한다.
- 이전 테스트에서는 개발자가 직접 주입했고, 여기서는 @Autowired에 의해 스프링이 주입해준다.

>참고: helloController는 스프링이 제공하는 컨트롤러여서 스프링 빈으로 자동 등록된다. `@Controller` 가 있으면 자동 등록됨
>

#### 컴포넌트 스캔 원리
- `@Component` 애노테이션이 있으면 스프링 빈으로 자동 등록된다.
- `@Controller` 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문이다.
- `@Component` 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록된다. 
   - `@Controller`
   -  `@Service`
   - `@Repository`

**회원 서비스 스프링 빈 등록** 
```java
@Service
public class MemberService {
  private final MemberRepository memberRepository;
  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
}
```

> 참고: 생성자에 `@Autowired` 를 사용하면 객체 생성 시점에 스프링 컨테이너에서 해당 스프링 빈을 찾아서 주입 한다. 생성자가 1개만 있으면 `@Autowired` 는 생략할 수 있다.

**회원 리포지토리 스프링 빈 등록** 

```java
@Repository
public class MemoryMemberRepository implements MemberRepository {}
```
![img3.png](img%2Fimg3.png)

- `memberService` 와 `memberRepository` 가 스프링 컨테이너에 스프링 빈으로 등록되었다.

> 참고: 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다(유일하게 하나만 등록 해서 공유한다) 따라서 같은 스프링 빈이면 모두 같은 인스턴스다. 설정으로 싱글톤이 아니게 설정할 수 있지만, 특별한 경우를 제외하면 대부분 싱글톤을 사용한다.

### 자바 코드로 직접 스프링 빈 등록하기

> 회원 서비스와 회원 리포지토리의 @Service, @Repository, @Autowired 애노테이션을 제거하고 진행한다.

``` java

package hello.hellospring;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {
  @Bean
  public MemberService memberService() {
      return new MemberService(memberRepository());
  }
  @Bean
  public MemberRepository memberRepository() {
       return new MemoryMemberRepository();
  }
}

```

# 회원 관리 예제 - 웹 MVC 개발
- [[/회원 웹 기능 - 홈 화면 추가]]()
- [[/회원 웹 기능 - 등록]]()
- [[/회원 웹 기능 - 조회]]()

## 회원 웹 기능 - 홈 화면 추가 

**홈 컨트롤러 추가**
```java
 package hello.hellospring.controller;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.GetMapping;
 @Controller
 public class HomeController {
     @GetMapping("/")
     public String home() {
         return "home";
     }
}
```
**회원 관리용 홈** 

```html
 <!DOCTYPE HTML>
 <html xmlns:th="http://www.thymeleaf.org">
 <body>
 <div class="container">
     <div>
<h1>Hello Spring</h1> <p>회원 기능</p>
<p>
<a href="/members/new">회원 가입</a>
<a href="/members">회원 목록</a> </p>
     </div>
 </div> <!-- /container -->
 </body>
</html>
```

<hr>

## 회원 웹 기능 - 등록 회원 등록 폼 개발

**회원 등록 폼 컨트롤러** 
```java
@Controller
public class MemberController {
private final MemberService memberService;
@Autowired
public MemberController(MemberService memberService) {
this.memberService = memberService;
}
@GetMapping(value = "/members/new")
public String createForm() {
return "members/createMemberForm";
}
}
```
**회원 등록 폼 HTML** ( `resources/templates/members/createMemberForm` ) 
```html
 <!DOCTYPE HTML>
 <html xmlns:th="http://www.thymeleaf.org">
 <body>
 <div class="container">
     <form action="/members/new" method="post">
 <div class="form-group">
<label for="name">이름</label>
<input type="text" id="name" name="name" placeholder="이름을 입력하세요">
</div>
<button type="submit">등록</button> </form>
 </div> <!-- /container -->
 </body>
</html>
```

<hr>

## 회원 등록 컨트롤러
**웹 등록 화면에서 데이터를 전달 받을 폼 객체** 
```java
package hello.hellospring.controller;
public class MemberForm {
private String name;
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
} }
```
**회원 컨트롤러에서 회원을 실제 등록하는 기능**

```java
 @PostMapping(value = "/members/new")
 public String create(MemberForm form) {
     Member member = new Member();
     member.setName(form.getName());
     memberService.join(member);
     return "redirect:/";
}
```

## 회원 웹 기능 - 조회 
**회원 컨트롤러에서 조회 기능**
```java
 @GetMapping(value = "/members")
 public String list(Model model) {
     List<Member> members = memberService.findMembers();
     model.addAttribute("members", members);
     return "members/memberList";
}
```
**회원 리스트 HTML** 
```html
 <!DOCTYPE HTML>
 <html xmlns:th="http://www.thymeleaf.org">
 <body>
 <div class="container">
     <div>
         <table>
             <thead>
             <tr>
                 <th>#</th>
<th>이름</th> </tr>
             </thead>
             <tbody>
             <tr th:each="member : ${members}">
                 <td th:text="${member.id}"></td>
                 <td th:text="${member.name}"></td>
             </tr>
             </tbody>
         </table>
</div>
 </div> <!-- /container -->
</body>
</html>
```