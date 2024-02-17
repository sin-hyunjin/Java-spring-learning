package poly.ex2;

public class Pig extends Animal{

    /** **Animal 클래스를 상속 받는 곳에서 `sound()` 메서드 오버라이딩을 하지 않을 가능성**
     예를 들어서 `Animal` 을 상속 받은 `Pig` 클래스를 만든다고 가정해보자. 우리가 기대하는 것은 `Pig` 클래스가
     `sound()` 메서드를 오버라이딩 해서 "꿀꿀" 이라는 소리가 나도록 하는 것이다. 그런데 개발자가 실수로 `sound()` 메서드를 오버라이딩 하는 것을 빠트릴 수 있다. 이렇게 되면 부모의 기능을 상속 받는다. 따라서 코드상 아무런 문제가 발생하지 않는다. 물론 프로그램을 실행하면 기대와 다르게 "꿀꿀"이 아니라 부모 클래스에 있는 `Animal.sound()` 가 호출될 것이다.*/

    // todo sound해야하는데....


}
