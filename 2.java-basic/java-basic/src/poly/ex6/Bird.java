package poly.ex6;

public class Bird extends AbstractAnimal implements Fly{
    /** `extends` 를통한상속은하나만할수있고 `implements` 를 통한 인터페이스는 다중 구현할 수 있기 때문에
     * 둘이함께 나온 경우 `extends` 가 먼저 나와야 한다.*/
    @Override
    public void sound() {
        System.out.println("짹쨱");
    }

    @Override
    public void fly() {
        System.out.println("새 날기");
    }
}
