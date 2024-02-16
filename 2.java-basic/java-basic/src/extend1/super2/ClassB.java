package extend1.super2;



public class ClassB extends ClassA{
    public ClassB(int a) {
        this(10,20); // 기본 생성자 생략 가능
        System.out.println("ClassB 생성자 a=" + a);
    }

    // this를 쓰더라도 언젠가는 super 부모를 호출해야한다.
    // 부모 생성자가 정의 되어야 자식 생성자에 문제가 없다.
    public ClassB(int a, int b) {
        super(); // 기본 생성자 생략 가능
        System.out.println("Class 생성자 a = " + a + " b = " + b);
    }
}
