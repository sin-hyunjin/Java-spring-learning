package construct;

public class MemberInit {
    String name;
    int age;
    int grade;

    //생성자가 없으면 자동으로 자바가 만들어준다
    MemberInit() { //생성자 필요할텐데??
    }
    void initMember( String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

}
