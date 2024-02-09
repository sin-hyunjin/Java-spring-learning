package pack.a;

/**
 * `pack` 하위에 `a` 라는 패키지를 먼저 만들자.
 * `pack.a` 패키지에 `User` 클래스를 만들었다.
 * 이후에 `User` 인스턴스가 생성되면 생성자를 통해 정보를 출력한다.
 */
public class User {
    public User() {
        System.out.println("패키지 pack.a 회원 생성");
    }
//    public User() {
//        System.out.println("패키지 pack.a 회원 생성");
//    }
}
