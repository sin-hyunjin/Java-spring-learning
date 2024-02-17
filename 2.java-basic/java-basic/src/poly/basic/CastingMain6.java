package poly.basic;


/** 자바 16 - Pattern Matching for instanceof
 자바 16부터는 `instanceof` 를 사용하면서 동시에 변수를 선언할 수 있다.
 */
public class CastingMain6 {

    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 호출");
        call(parent1);
        Parent parent2 = new Child();
        System.out.println("parent2 호출");
        call(parent2);
    }

    private static void call(Parent parent) {
        parent.parentMethod();

        /** 오른쪽에 있는 타입에 왼쪽에 있는 인스턴스의 타입이 들어갈 수 있는지 대입해보면 된다. 대입이 가능 하면 `true` , 불가능하면 `false` 가 된다.
         * Child 인스턴스인 경우 childMehtod()실행*/

         if (parent instanceof Child child) {
            System.out.println("Child 인스턴스 맞음");
            child.childMethod();
        }
    }
    
}
