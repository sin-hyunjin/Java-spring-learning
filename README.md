# 목차

## 1.Hello World 

- [개발 환경 설정](intelli j를 통한 자바 컴파일 과정 )
- [주석(comment)]([CommentJava.java](src%2FCommentJava.java))


# 자바란? 

자바 표준 스펙과 구현 

![image](https://github.com/sin-hyunjin/JAVA-Study/assets/116487398/d05261ff-745e-49a6-96d2-67032db9e395)

- 자바 표준 스펙
  - 자바는 이렇게 만들어야한다는 설계도,문서이다
  - 자바 표준스펙은 자바 커뮤니티 프로세스(JCP)를 통해 관리된다.

> 참고 : 자바 구현 참고 사이트 https://whichjdk.com/

### 컴파일과 실행 

![image](https://github.com/sin-hyunjin/JAVA-Study/assets/116487398/d5e8be5b-28d8-4693-a19d-f8fd25b49632)

자바 프로그램은 컴파일과 실행 단계를 거친다 

- Hello.java와 같은 자바 소스코드를 개발자가 작성한다.
- 자바 컴파일러를 사용해서 소스코드를 컴파일 한다.
  - 자바가 제공하는 javac라는 프로그램을 사용
  - .java -> .class 파일이 생성

#### intelli j를 통한 자바 컴파일 과정 

![image](https://github.com/sin-hyunjin/JAVA-Study/assets/116487398/af5709e2-f4d9-4c33-92e3-ce2326e11e89)

- 컴파일
  - 자바 코드를 컴파일할려면 javac라는 프로그램을 직접사용 해야하는데, Intelli j는 이과정을 자동 처리해줌

<img width="242" alt="image" src="https://github.com/sin-hyunjin/JAVA-Study/assets/116487398/a90ce578-1683-49a1-b0f6-829550ebc847">

- out에서 확인가능

#### 자바 개발과 운영 환경 

![image](https://github.com/sin-hyunjin/JAVA-Study/assets/116487398/08b13c84-8cbd-4633-8493-24527c301a91)

- 개발할 때 자바와 서버에서 실행할 떄 다른 자바를 사용가능
- 서버는 주로 리눅스사용. 만약 aws를 사용한다면 amazon corretto 자바를 aws 리눅스 서버에 설치하면 가능
- 자바의 운영체제 **독립성** 때문에 가능 


