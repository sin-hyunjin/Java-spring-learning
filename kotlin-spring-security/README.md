
# 목차 

- [1. Kotlin 문법](#1-kotlin)
  - [1.1.  var / val](#11-var--val)
  - [ 1.2. ? / ?. / ?: / !!](#12-------)
  - [1.3. if / when](#13-if--when)
  - [1.4. class--data-class--enum-class](#14-class--data-class--enum-class)
  
- [2. 회원가입 기능 만들기](#회원가입-기능-만들기)
  - [2.0 요구사항 ](#0-요구사항-)
  - [2.1 validation 추가하기 ](#1-validation-추가하기-)
  - [2.2 BaseResponse 만들기 ](#2-baseresponse-만들기-)
  - [2.3 ExceptionHandler 만들기 ](#3-exceptionhandler-만들기-)
- [3. 권한 관리](#3-권환-관리-방법-)
  - [인증과 인가](#인증과-인가)
  - [Spring Security](#spring-security)
  - [JWT ](#jwt-)
  - [JwtToken 만들기 ](#jwttoken-만들기-)
- [4. 로그인 기능 만들기]()
- [5. 내 정보 변경 기능 만들기]()

# 1. Kotlin
### [Kotlin playground 사이트](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS45LjIxIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiLyoqXG4gKiBZb3UgY2FuIGVkaXQsIHJ1biwgYW5kIHNoYXJlIHRoaXMgY29kZS5cbiAqIHBsYXkua290bGlubGFuZy5vcmdcbiAqL1xuZnVuIG1haW4oKSB7XG4gICAgcHJpbnRsbihcIkhlbGxvLCB3b3JsZCEhIVwiKVxufSJ9)에서 실습해보기

- [1.1.  var / val](#11-var--val)
- [ 1.2. ? / ?. / ?: / !!](#12-------)
- [1.3. if / when](#13-if--when)
- [1.4. class--data-class--enum-class](#14-class--data-class--enum-class)

## 1.1 var / val

### var 

```java 
fun main() {
    var a = 1;
    a = 2;
    println(a);
}
```
- 읽기 쓰기 가능 
```java 
fun main() {
    var a = 1;
// a = "a" // Type mismatch
    println(a::class)
    
}
```
- 타입 추론으로 입력된 값에 의해 자동으로 타입을 잡아줌
- 다른 타입의 데이터를 넣으러고 하면 Type mismatch 

#### val 

```html
fun main() {
val a = 1
// a = 2 // 변경 불가
println(a)
}
```
- 읽기만 가능
- 코딩을 할때 기본적으로 val 로 하고 변경이 필요할 경우만 var 로 변경 권장

#### 타입 추론 

```java 
fun main() {
val s = "ABC"
val i = 1
val l = 1L
val d = 1.0
val f = 1.0f
println("s = " + s::class)
println("i = " + i::class)
println("l = " + l::class)
println("d = " + d::class)
println("f = " + f::class)
}
```
- kotlin은 타입추론으로 변수에 들어오는 값을 보고 타입을 알아서 지정해줌
- 코딩을 할때 타입추론이 되더라도 직접 명시하는 것을 권장

## 1.2. ? / ?. / ?: / !!
1. ?
```java
fun main() {
    val str: String? = null
    // val str2: String = null // null 허용하지 않음
}
```
- type에 ? 를 붙이면 null 허용
- 
2. ?.
```java
   fun main() {
   val str: String? = "ABC"
   println(str?.length)
   val str2: String? = null
   println(str2?.length)
   }
   ```
- null safe call operator
- ?. 앞의 값이 null 이 아니면 뒤에 명령어 실행, null 이면 null 반환
3. ?:
```java
   fun main() {
   val str: String? = "ABC"
   str ?: println("str is null")
   val str2: String? = null
   str2 ?: println("str2 is null")
   }
   ```
- Elvis operator
- ?: 앞에 값이 null 이라면 뒤에 명령어 실행

4. !!
```java
   fun main() {
   val str: String? = "ABC"
   println(str!!.length)
   }
   ```
   - null 허용하는 변수를 null이 아님을 보장
   - !!로 해줬는데 실행시 null 인경우 NullPointerException 발생

## 1.3. if / when

### 1. if 문
   형태

```java
   if ( 조건식 ) {
   // 조건식이 true인 경우 실행
   } else {
   // 조건식이 false인 경우 실행
   }
```

대소 비교
```java
fun main() {
   val a: Int = 100
   val b: Int = 200
   if (a >= b) {
        println("a = $a")
   } else {
        println("b = $b")
   }
}
```
null 체크

```java
fun main() {
    
   val a: Int? = null
            
   if (a == null) {
         println("null check true")
   } else {
         println("a = $a")
   }
}
```
   in 체크
   
```java
fun main() {
    val a: Int = 100
    if (a in arrayOf(100, 200, 300)) {
        println("contain")
    } else {
        println("not contained")
    }
}
```

## 2. when 문
   형태
```java 
   when ( 변수 ) {
   조건1 -> 조건1 만족시 실행 후 when 밖으로 이동
   조건2 -> 조건2 만족시 실행 후 when 밖으로 이동
   조건3 -> 조건3 만족시 실행 후 when 밖으로 이동
   // ...
   else -> 아무것도 만족하지 않을때 실행
   }
   ```
   값 비교

```java 
   fun main() {
   val a: Int = 100
   when (a) {
   100 -> println("1. a = $a")
   200 -> println("2. a = $a")
   300 -> println("3. a = $a")
   else -> println("4. Not")
   }
   }
   ```

   범위 비교
``` java
 fun main() {
   val a: Int = 100
   
   when (a) {
   in 100..199 -> println("1. 100 ~ 199")
   }
 }
```
## 1.4. class / data class / enum class

### 1. class
   형태
```java 
   class 클래스명 {
   // 프로퍼티와 메소드
   }
```
```java 
   생성자로 인스턴스 생성
   fun main() {
   val item = Item("BOOK", 10_000)
   println("Item name is ${item.name}, price is ${item.price}")
   }
   class Item(val name: String, val price: Int)
```

### 2. data class
```
   data class MemberDto(
   val name: String,
   val birthDate: LocalDate,
   val gender: Gender,
   val email: String,
   )
```
- DTO 만들때 사용
- getter, setter(var 인 경우), equals, hashCode, toString, copy, componentN 자동 생
   성

### 3. enum class
```java
enum class Color {
RED,
GREEN,
BLUE
}
```
상수들을 모아놓은 집합

# 회원가입 기능 만들기 

## application.yml 셋팅 

```java
server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: UTF-8
      enabled: true
      force: true
spring:
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    url: jdbc:mariadb://localhost:3306/study
    username: root
    password: coavldjs3372!@
  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: create
    properties:
      hibernate:
        show_sql: false
        format_sql: true
        highlight_sql: true
logging:
  pattern:
    console: "[%d{HH:mm:ss.SSS}][%-5level][%logger.%method:line%line] - %msg%n"
  level:
    org:
      hibernate:
        SQL: debug
        type.descriptor.sql: trace


```

### server : 서버 관련 설정 
- server.port : 서버 포트(default. 8080)
- server.servlet.encoding.charset : HTTP 요청과 응답의 문자 집합
- server.servlet.encoding.enabled : HTTP 인코딩 지원 여부
- server.servlet.encoding.force : HTTP 요쳥과 응답에서 문자 집합에 인코딩을 강제할지 여부 

## spring.datasource : Database 접속 정보

## spring.jpa : jpa 설정 정보 

- spring.jpa.open-in-view : true일 경우 영속성 컨텍스트가 트랜잭션 범위를 넘어선 레이어까지 유지 
- spring.jpa.hibernate.ddl-auto
  - create : 기존테이블 삭제후 다시생성 ( DRAP + CREATE)
  - create-drop : create와 같으나 종료시점에 테이블 DROP
  - create update : 변경분만 반영(운영DB에서는 사용해서는 안됨)
  - validate : 엔티티와 테이블 정상 매핑되었는지만 확인(운영DB)
  - none: 사용하지 않음

- spring.jpa.properties.hibernate.show_sql: System.out에 sql 로그출력
- spring.jpa.properties.hibernate.format_sql : sql을 보기좋게 줄맞춤
- spring.jpa.properties.hibernate.highlight_sql : sql 색상 표시추가 

## logging: 로그에 관한 정보
- logging.pattern.console : 기본 로그 형태 지정
- logging.level.org.hibernate.SQL : logger 에 sql로그 출력(권장)
- logging.level.org.hibernate.type.descriptor.sql : trace로 하면 sql에 바인딩 되는 값을 확인

# 회원가입 기능 만들기
 - [0. 요구사항 ](#0-요구사항-)
 - [1. validation 추가하기 ](#1-validation-추가하기-)
 - [2. BaseResponse 만들기 ](#2-baseresponse-만들기-)
 - [3. ExceptionHandler 만들기 ](#3-exceptionhandler-만들기-)
## 0. 요구사항 

### ENPOINT 

```java
POST /api/member/signup
```

### 회원가입시 입력받을 정보 

![img.png](img%2Fimg.png)

### 패키지 정의 

![img_1.png](img%2Fimg_1.png)


- com.example.demo.common : 
   - annotation : 사용자 생성 어노테이션
   - dto : 어플리케이션 전반에 공통적으로 사용할 수 있는 DTO
   - exception : exception cjfl
   - status : 어플리케이션 상태관리 
- com.example.demo.member : 회원정보 관련 기능 분류
  - controller : Request 를 받을 End Point
  - dto : 회원정보 관련 DTO
  - entity : 회원정보 관련 ENtity
  - repository : 회원정보 관련
  - service : 비즈니스 로직 


## 1. validation 추가하기 
### 1.1 build.gradle.kts > dependencies에 의존성 추가 

> implementation("org.springframework.boot:spring-boot-starter-validation")

- validation을 사용하기 위해 Maven Repository 에서 spring validation 검색 후 추가 
   
### 1.2 Enum 체크할 Validator 생성

```java
package com.example.auth.common.annotation
import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [ValidEnumValidator::class])
annotation class ValidEnum(
    val message: String = "Invalid enum value",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val enumClass: KClass<out Enum<*>>
)
class ValidEnumValidator : ConstraintValidator<ValidEnum, Any> {
    private lateinit var enumValues: Array<out Enum<*>>
    override fun initialize(annotation: ValidEnum) {
        enumValues = annotation.enumClass.java.enumConstants
}
    override fun isValid(
        value: Any?,
        context: ConstraintValidatorContext): Boolean {
        if (value == null) {
            return true
        }
        return enumValues.any { it.name == value.toString() }
  }
}

```

- @Target : 어노테이션이 지정되어 사용할 종류를 정의
- @Retention : 어노테이션을 컴파일된 클래스 파일에 저장할 것인지 런타임에 반영할 것인지 정의
   - SOURCE: binary 파일로 명시되지 않음
   - BINARY: binary 파일에는 명시되지만 reflection 에는 명시되지 않음
   - RUNTIME: binary 파일과 reflection 둘다 명시
- @MustBeDocumente : API 일부분으로 문서화하기 위해 사용 

### 1.3 DTO에 validation 추가 

```java
package com.example.demo.member.dto

import com.example.demo.common.annotation.ValidEnum
import com.example.demo.common.status.Gender
import com.example.demo.member.entity.Member
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import java.time.LocalDate
import java.time.format.DateTimeFormatter

// 회원가입시 입력받을 정보
data class MemberDtoRequest(
    val id: Long?,

    // loginId, password, name, birthDate, gender, email에 대한 필수 입력 및 유효성 검사 어노테이션 추가
    @field:NotBlank
    @JsonProperty("loginId")
    private val _loginId: String?,

    @field:NotBlank
    @field:Pattern(
        regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#\$%^&*])[a-zA-Z0-9!@#\$%^&*]{8,20}\$",
        message = "영문, 숫자, 특수문자를 포함한 8~20자리로 입력해주세요."
    )
    @JsonProperty("password")
    private val _password: String?,

    @field:NotBlank
    @JsonProperty("name")
    private val _name: String?,

    @field:NotBlank
    @field:Pattern(
        regexp = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$",
        message = "날짜형식(YYYY-MM-DD)을 확인해주세요"
    )
    @JsonProperty("birthDate")
    private val _birthDate: String?,

    @field:NotBlank
    @field:ValidEnum(enumClass = Gender::class, message = "MAN이나 WOMAN중 하나를 선택해주세요")
    @JsonProperty("gender")
    private val _gender: String?,

    @field:NotBlank
    @field:Email
    @JsonProperty("email")
    private val _email: String?,
) {
    // Getter 메서드에서 null이 아님을 보장하기 위해 !! 연산자 사용
    val loginId: String
        get() = _loginId!!

    val password: String
        get() = _password!!

    val name: String
        get() = _name!!

    // 문자열 형태의 날짜를 LocalDate로 변환하는 확장 함수
    private fun String.toLocalDate(): LocalDate =
        LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    val birthDate: LocalDate
        get() = _birthDate!!.toLocalDate()

    // 문자열 형태의 성별을 Gender 열거형으로 변환하는 확장 함수
    val gender: Gender
        get() = Gender.valueOf(_gender!!)

    val email: String
        get() = _email!!

    fun toEntity(): Member =
        Member(id, loginId, password, name, birthDate, gender, email)
}

```

### 1.4 controller에 @vaild 추가 
```java
@PostMapping("/signup")
fun signUp(@RequestBody @Valid memberDtoRequest: MemberDtoRequest):BaseResponse<Unit> {
    val resultMsg: String = memberService.signUp(memberDtoRequest)
    return BaseResponse(message = resultMsg)
}
```

- @Valid가 있어야 DTO에 데이터를 담은 후 유효성 검사가 가능 

## 2 BaseResponse 만들기 

### 2.1 ResultCode enum class 생성 

```java
package com.example.demo.common.status

enum class Gender(val desc: String) {
    MAN("남"),
    WOMAN( "여")
}

enum class ResultCode(val msg: String) {
    SUCCESS("정상 처리 되었습니다."),
    ERROR("에러가 발생했습ㄴ디ㅏ.")
}

```

### 2.2 BaseResponse 생성 
```java
package com.example.demo.common.dto

import com.example.demo.common.status.ResultCode
import org.aspectj.bridge.Message

data class BaseResponse<T> (
    // 결과코드
    val resultCode: String = ResultCode.SUCCESS.name,
    // 조희 처리시 data property에 값을 넣어서 반환해줄 꺼임
    val data: T? = null,
    // 처리메시지
    val message: String = ResultCode.SUCCESS.msg,

    )

```

## 3 ExceptionHandler 만들기 
### 3.1 InvalidInputException 생성
```java
package com.example.demo.common.exception

class InvalidInputException(
    val fieldName: String = "",
    message: String = "Invalid Input"
) : RuntimeExc
```

- @valid 외에 필드값이 문제가 있어서 exception을 발생시킬때 사용

### 3.2 CustomExceptionHandler 생성 

```java
package com.example.demo.common.exception

import com.example.demo.common.dto.BaseResponse
import com.example.demo.common.status.ResultCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * `@RestControllerAdvice`를 사용하여 컨트롤러에서 발생하는 예외들을 처리하는 클래스
 */
@RestControllerAdvice
class CustomExceptionHandler {

    /**
     * `MethodArgumentNotValidException` 예외를 처리하는 메서드
     * 주로 입력값의 유효성 검사에서 발생한 예외를 처리함
     * 바인딩된 결과에서 필드 에러를 추출하고, 에러 메시지를 맵에 담아 응답함
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun handleValidationExceptions(ex: MethodArgumentNotValidException):
            ResponseEntity<BaseResponse<Map<String, String>>> {
        val errors = mutableMapOf<String, String>()
        ex.bindingResult.allErrors.forEach { error ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.getDefaultMessage()
            errors[fieldName] = errorMessage ?: "Not Exception Message"
        }
        return ResponseEntity(BaseResponse(
            ResultCode.ERROR.name,
            errors,
            ResultCode.ERROR.msg
        ), HttpStatus.BAD_REQUEST)
    }

    /**
     * `InvalidInputException` 예외를 처리하는 메서드
     * 사용자 정의 예외로, 필드 이름과 에러 메시지를 응답함
     */
    @ExceptionHandler(InvalidInputException::class)
    protected fun invalidInputException(ex: InvalidInputException):
            ResponseEntity<BaseResponse<Map<String, String>>> {
        val errors = mapOf(ex.fieldName to (ex.message ?: "Not Exception Message"))
        return ResponseEntity(BaseResponse(
            ResultCode.ERROR.name,
            errors,
            ResultCode.ERROR.msg
        ), HttpStatus.BAD_REQUEST)
    }

    /**
     * 그 외 모든 예외를 처리하는 기본 메서드
     * 예외 메시지를 맵에 담아 응답함
     */
    @ExceptionHandler(Exception::class)
    protected fun defaultException(ex: Exception):
            ResponseEntity<BaseResponse<Map<String, String>>> {
        val errors = mapOf(" " to (ex.message ?: "Not Exception Message"))
        return ResponseEntity(BaseResponse(
            ResultCode.ERROR.name,
            errors,
            ResultCode.ERROR.msg
        ), HttpStatus.BAD_REQUEST)
    }
}

```

# 3. 권환 관리 방법 
- [인증과 인가](#인증과-인가)
- [Spring Security](#spring-security)
- [JWT ](#jwt-)
- [JwtToken 만들기 ](#jwttoken-만들기-)
- []()
## 인증과 인가
  - 인증(Authentication) : 해당 사용자가 본인이 맞는지 확인하는 절차
  - 인가(Authorization) : 인증된 사용자가 요청된 자원에 접근 가능한지를 결정하는 절차

## Spring Security
- 어플리 케이션의 보안을 담당하는 스프링 하위 프렘워크
- 인증과 인가에대한 부분을 Filtergmfmadp EKfk cjfl 

##  JWT 
https://jwt.io/

#### 생성 
1. TokenInfo
- 로그인시 토큰 정보를 담아 클라이언트에게 전달하는 용도 

2. JwtTokenProvider
- Token 생성, Token 정보 추출, Token 검증 

3. JwtAuthenticationFilter
- GenericFilterBean 상송
- Fliter로 Token 정보를 검사하고 SecurityContextHolder에 authentication을 기록


4. SecurityConfig
- 인증 및 인가 관리

5. CustomUserDetailsService
- UserDetailService 구현
- loadUserByUsername override

## JwtToken 만들기 

### 1. build.gradle.kts > dependencies에 의존성 추가 
```java

// Spring Security 
implementation("org.springframework.boot:spring-boot-starter-security")
// JWT
implementation("io.jsonwebtoken:jjwt-api:0.11.5")
runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
```
- 권한 관리를 위해 spring Security + JWT사용 

### 2. application.yml 에 secretKey 추가 
```java
jwt:
  secret: DadFufN4Oui8Bfv3ScFj6R9fyJ9hD45E6AGFsXgFsRhT4YSdSb
```