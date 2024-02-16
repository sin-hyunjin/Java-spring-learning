package extend1.overriding;

public class ElectricCar extends Car {

    @Override // 부모 기능을 재정의
    public void move() {
        System.out.println("전기차를 빠르게 충전합니다.");
    }

    public void charge() {
        System.out.println("충전합니다.");
    }

}
