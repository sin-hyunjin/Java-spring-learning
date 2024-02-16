package static2.ex;

public class CarMain {
    public static void main(String[] args) {
        Car car1 = new Car("k3");
        Car car2 = new Car("G80");
        Car car3 = new Car("Model Y");

        // 클래스로 접근
        Car.showTotalCars(); //구매한 차량 수를 출력하는 static 메서드
    }
}

