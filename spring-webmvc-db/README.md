# 목차 
- [1.프로젝트 환경 설정](#1-프로젝트-환경-설정)
- [2.스프링 웹 개발 기초](#2-스프링-웹-개발-기초-)
  - [/정적 컨텐츠](#정적-컨텐츠-)
  - [/MVC와 템플릿 엔진](#mvc와-템플릿-엔진-)
  - [/API (json)](#api)

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
