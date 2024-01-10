package class1;

public class ClassStart3 {
    public static void main(String[] args) {
        Student student1; //`Student` 타입을 받을 수 있는 변수를 선언한다.
        student1 = new Student(); //x001 `new Student()` 는 `Student` 클래스 정보를 기반으로 새로운 객체를 생성하라는 뜻
        /** 2. 객체 생성
         *`Student` 클래스는 `String name` , `int age` , `int grade` 멤버 변수를 가지고 있다.
         * 이 변수를 사용하는 데 필요한 메모리 공간도 함께 확보
         * 객체를 생성하면 자바는 메모리 어딘가에 있는 이 객체에 접근할 수 있는 참조값(주소)( `x001` )을 반환
         */
        student1.name = "학생1"; //1. student1 객체의 name 멤버 변수에 값 대입
        student1.age = 15; 
        student1.grade = 90;

        // new Student(); = 실제 메모리에 만들어진 객체 또는 인스턴츠
        Student student2 = new Student(); //x002
        student2.name = "학생2";
        student2.age = 16;
        student2.grade = 80;

        // 참조값 확인
        System.out.println("student1 = " + student1);
        System.out.println("student2 = " + student2);

        System.out.println("이름:" + student1.name + " 나이:" + student1.age + " 성적:" + student1.grade);
        System.out.println("이름:" + student2.name + " 나이:" + student2.age + " 성적:" + student2.grade);


    }
}
