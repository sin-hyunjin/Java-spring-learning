package poly.car1;
/**
 * 다형성을 활용한 런타임 변경
 * 런타임: 애플리케이션 실행 도중에 변경 가능
 * */

/**
 * `Car` 를 사용하는 클라이언트 코드인 `Driver` 코드의 변경없이 새로운 자동차를 확장할 수 있다.
 * 다형성을 활용하고 역할과 구현을 잘 분리한 덕분에 새로운 자동차를 추가해도 대부분의 핵심 코드들을 그대로 유 지할 수 있게 되었다.
 */
public class CarMain1 {
    public static void main(String[] args) {
        Driver driver = new Driver();

        //차량 선택(k3)
        K3Car k3Car = new K3Car();
        driver.setCar(k3Car);
        driver.drive();

        //차량 변경(k3 -> model3)
        Model3Car model3Car = new Model3Car();
        driver.setCar(model3Car);
        driver.drive();


        //차량 변경 (model3 -> NewCar)
        NewCar newCar = new NewCar();
        driver.setCar(newCar);
        driver.drive();

    }
}
