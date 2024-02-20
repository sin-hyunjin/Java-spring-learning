package poly.car0;

public class CarMain0 {
    public static void main(String[] args) {

        /**
         *
         K3를 운전하던 운전자가 Model3로 차량을 변경해서 운전하는 코드이다.
         `driver.setK3Car(null)` 을 통해서 기존 `K3Car` 의 참조를 제거한다.
         `driver.setModel3Car(model3Car)` 를 통해서 새로운 `model3Car` 의 참조를 추가한다.
         `driver.driver()` 를 호출한다.
         */
        Driver driver = new Driver();
        K3car k3car = new K3car();

        driver.setK3Car(k3car);
        driver.drive();

        Model3Car model3Car = new Model3Car();
        driver.setK3Car(null);
        driver.setModel3Car(model3Car);
        driver.drive();
    }
}
