package ref;

public class MethodChange1 {

    public static void main(String[] args) {
        int a = 10;
        System.out.println("메서드 호출 전 : a" + a);
        // 1. 메서드 호출, 값 전달 : 10
        changePrimivice(a);
        System.out.println("메서드 호출 후 : a" + a);
    }
    static int changePrimivice(int x) {
        x = 20; // 결과적으로 x값만 10으로 변환된것이다
        System.out.println("x = " + x);
        return x;
    }
}
