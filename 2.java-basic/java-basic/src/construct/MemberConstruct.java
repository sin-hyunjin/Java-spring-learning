package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    /** 생성자
     * 생성자는 메서드와 비슷하지만 다음과 같은 차이가 있다.
     * 생성자의 이름은 클래스 이름과 같아야 한다. 따라서 첫 글자도 대문자로 시작한다.
     * 생성자는 반환 타입이 없다. 비워두어야 한다.
     * 나머지는 메서드와 같다.
     * **생성자를 사용하면 필수값 입력을 보장할 수 있다** (유령회원차단)
     */

    // 참고:** 좋은 프로그램은 무한한 자유도가 주어지는 프로그램이 아니라 적절한 제약이 있는 프로그램이다.

    // 추가 grade값이 없으면 50점이 된다.
    MemberConstruct(String name, int age) {
        // this는 첫번째 문장에만 작성할수 있다
        this(name, age, 50); //변경 이렇게 쓰면 아래의 생성자를 호출한다

        System.out.println("123"+this);
    //`this()` 라는 기능을 사용하면 생성자 내부에서 자신의 생성자를 호출할 수 있다. 참고로 `this` 는 인스턴스 자신 의 참조값을 가리킨다.
    }


    MemberConstruct(String name, int age, int grade) {
        System.out.println("생성자 호출 name=" + name + ",age=" + age + ",grade=" +
                grade);
        System.out.println("this = " + this);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
