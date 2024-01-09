package method;

public class Overloading2 {

    public static void main(String[] args) {
        myMethod(1, 1.2); // 정수, 실수 이기때문에 첫번ㄷ째 매서드가 호출
        myMethod(1.2, 1); // 실수, 정수 이기때문에 두번째 메서드가 호출
    }

    public static void myMethod(int a, double b) {
        System.out.println("int a, double b");
    }

    public static void myMethod(double a, int b) {
        System.out.println("double a, int b");
    }
}
