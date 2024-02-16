package extend1.ex3;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar(); // Car를 상속받아서 인스턴스를 생성하면 참조값은 하나지만 두가지 클래스가 존재한다.
        electricCar.move(); //electricCar는 move가 없지만 상속받아서 사용가능
        electricCar.stop();
        electricCar.charge();
        electricCar.openDoor();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();

        HydrogenCar hydrogenCar = new HydrogenCar();
        hydrogenCar.move();
        hydrogenCar.stop();
        hydrogenCar.fillHydrogen();
    }
}
