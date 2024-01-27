package class1;

public class ClassStart4 {
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

        // ⭐ 자바에서 대입은 항상 변수에 들어 있는 값을 복사한다.
        Student[] students = new Student[2]; // Student` 변수를 2개 보관할 수 있는 사이즈 2의 배열을 만듬
        students[0] = student1; // student1의 참조값만 students[0]에 들어있는것이다
        students[1] = student2; // student2의 참조값만 students[1]에 들어있는것이다
        //이제 배열은 `x001` , `x002` 의 참조값을 가진다. 참조값을 가지고 있기 때문에 `x001` (학생1), `x002` (학생2) `Student` 인스턴스에 모두 접근할 수 있다.


        System.out.println("이름:" +  students[0].name + " 나이:" +  students[0].age + " 성적:" +  students[0].grade);
        System.out.println("이름:" + students[1].name + " 나이:" + students[1].age + " 성적:" + students[1].grade);


    }
}
