package poly.ex3;


/** 추상메서드
 * - 추상 메서드가 하나라도 있는 클래스는 추상 클래스로 선언해야 한다.
 * - 추상 메서드가 상속 받는 자식 클래스가 반드시 Overriding 해서 사용하애 햔다.
 * - 추상 메서드는 기존 메서드와 완전히 같지만, 바디가 없고, 자식 클래스의 Overriding 제약이 추가된 것 이다.
 */
public abstract class AbstractAnimal {
    public abstract void sound();

    public void move() {
        System.out.println("동물이 움직입니다.");
    }

}
