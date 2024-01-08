보안 

인증 : 본인을 확인하는 것 

인가 : 권환을 확인하는 것

# 목차 

- [1. Kotlin 문법](#1-kotlin)
- [2. 회원가입 기능 만들기]()
- [3. 권한 관리]()
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