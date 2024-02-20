package poly.car0;

public class Driver {
    private K3car k3Car;
    private Model3Car model3Car; // 추가

    // 생성자가 아니라 다른곳에서 셋팅할 수 있게 함
    public void setK3Car(K3car k3car) {
        this.k3Car = k3car;
    }

    public void setModel3Car(Model3Car model3Car) {
        this.model3Car = model3Car;
    }


    public void drive() {
        System.out.println("자동차를 운전합니다.");
        if (k3Car != null) {
            k3Car.startEngine();
            k3Car.pressAccelerator();
            k3Car.offEngine();
        } else if (model3Car != null) {
            model3Car.startEngine();
            model3Car.pressAccelerator();
            model3Car.offEngine();
        }
    }

}
