package operator;
/* 증감연산자

 */
public class OperatorAdd1 {

    public static void main(String[] args) {
        // 기존의 a값을 증가하는 방법
        int a = 0;

        a = a + 1;
        System.out.println("a = " + a); // 1

        a = a + 1;
        System.out.println("a = " + a); // 2

        // 증감 연산자
        ++a; // a = a + 1
        System.out.println("a = " + a); // 3
        ++a; // a = a + 1
        System.out.println("a = " + a); // 4

        --a;
        System.out.println("a = " + a); // 3
    }
}
