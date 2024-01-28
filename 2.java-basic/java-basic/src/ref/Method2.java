package ref;

public class Method2 {

    public static void main(String[] args) {
        // 1. createStudent 메서드 호출
        Student student1 = createStudent("학생1", 15, 90); //
        Student student2 =createStudent("학생2", 16, 80);

        printStudent(student1);
        printStudent(student2);
    }

    static Student createStudent(String name, int age, int grade) {
        // 2. 인스턴스 생성, 초기값 설정
        // 모든 객체를 만든후 참조값을 반환
        Student student = new Student();
        student.name = name;
        student.age = age;
        student.grade = grade;
        // 3. 메서드 반환
        return student;
    }

    static void printStudent(Student student1) {
        System.out.println("이름:" + student1.name + " 나이:" + student1.age + " 성적:" + student1.grade);
    }
}
