package poly.basic;

/**
 * **다형적 참조의 핵심은 부모는 자식을 품을 수 있다는 것이다.**
 * 그런데 이런 다형적 참조가 왜 필요하지? 라는 의문이 들 수 있다.
 * 이 부분은 다형성의 다른 이론들도 함께 알아야 이해 할 수 있다. 지금은 우선 다형성의 문법과 이론을 익히는데 집중하자.
 */
public class PolyMain {

    public static void main(String[] args) {
        // 부모 변수가 부모 인스턴스 참조
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();

        System.out.println("----------------------");

        //자식 변수가 자식 인스턴스 참조
        System.out.println("Child -> Child");
        Child child = new Child();
        child.parentMethod();
        child.childMethod();

        System.out.println("----------------------");

        //부모 변수가 자식 인스턴스 참조(다형적 참조)
        System.out.println("Parent -> Child");
        Parent poly = new Child();
        poly.parentMethod();

        System.out.println("----------------------");

        // Child child1 = new Parent(); 자식은 부모를 담을 수 없다.

        // poly.childMethod();
        /**
//        자식의 기능은 호출할 수 없다. 컴파일 오류 발생
//        이런 경우 `childMethod()` 를 호출하고 싶으면 어떻게 해야할까? 바로 캐스팅이 필요하다.
         */


    }
}
