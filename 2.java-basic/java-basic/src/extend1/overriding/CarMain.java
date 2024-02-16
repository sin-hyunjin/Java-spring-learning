package extend1.overriding;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar(); // Car를 상속받아서 인스턴스를 생성하면 참조값은 하나지만 두가지 클래스가 존재한다.
        electricCar.move(); //electricCar는 move가 없지만 상속받아서 사용가능


        GasCar gasCar = new GasCar();
        gasCar.move();

    }
}
