package poly.basic;


/** instansOf
 * 어떤 인스턴스를 참조하고 있는지 확인
 */
public class CastingMain5 {

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

        /** 오른쪽에 있는 타입에 왼쪽에 있는 인스턴스의 타입이 들어갈 수 있는지 대입해보면 된다. 대입이 가능 하면 `true` , 불가능하면 `false` 가 된다. */
         if (parent instanceof Child) {
            System.out.println("Child 인스턴스 맞음");
            ((Child) parent).childMethod();
        }
    }
    
}
